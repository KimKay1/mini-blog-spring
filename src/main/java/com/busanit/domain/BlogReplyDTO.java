package com.busanit.domain;

import com.busanit.entity.BlogReply;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BlogReplyDTO {

    private Long rIdx;
    private String content;
    private Long idx;

    // Entity -> DTO 변환
    public static BlogReplyDTO toDTO(BlogReply blogReply) {
        return BlogReplyDTO.builder()
                .rIdx(blogReply.getRIdx())
                .content(blogReply.getContent())
                .build();
    }
}
