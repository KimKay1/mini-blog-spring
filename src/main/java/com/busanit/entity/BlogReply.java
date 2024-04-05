package com.busanit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class BlogReply extends BaseEntity {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rIdx;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Blog blog;
}
