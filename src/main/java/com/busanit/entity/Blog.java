package com.busanit.entity;

import com.busanit.domain.BlogDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "blog")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String title;

    private String content;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<BlogReply> blogReplyList;

    // DTO -> Entity
    public static Blog toEntity(BlogDTO dto) {
        BlogBuilder builder = Blog.builder()
                .title(dto.getTitle())
                .content(dto.getContent());

        // idx값이 없을 경우 insert
        // idx값이 있을 경우 update
        if(dto.getIdx() != null) {
            builder.idx(dto.getIdx());
        }

        return builder.build();
    }
}
