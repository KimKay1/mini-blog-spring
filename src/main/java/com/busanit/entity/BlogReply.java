package com.busanit.entity;

import com.busanit.domain.BlogDTO;
import com.busanit.domain.BlogReplyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogReply extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rIdx;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Blog blog;

    // DTO -> Entity
    public static BlogReply toEntity(BlogReplyDTO dto) {

        // Blog에서 게시물의 idx값 가져오기
        Blog blog = new Blog();
        blog.setIdx(dto.getIdx());

        BlogReplyBuilder builder = BlogReply.builder()
                .content(dto.getContent())
                .blog(blog); // 게시물과의 관계 설정

        // rIdx값이 없을 경우 insert
        // rIdx값이 있을 경우 update
        if(dto.getRIdx() != null) {
            builder.rIdx(dto.getRIdx());
        }

        return builder.build();
    }
}
