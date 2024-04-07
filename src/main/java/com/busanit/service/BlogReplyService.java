package com.busanit.service;

import com.busanit.domain.BlogReplyDTO;
import com.busanit.entity.BlogReply;
import com.busanit.repository.BlogReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogReplyService {

    private final BlogReplyRepository blogReplyRepository;

    public void writeReply(BlogReplyDTO dto) {
        BlogReply blogReply = BlogReply.toEntity(dto);

        blogReplyRepository.save(blogReply);
    }

    // rIdx로 해당 댓글의 부모 게시물을 식별하는 메서드
    public Long getParentPostIdx(Long rIdx) {
        Optional<BlogReply> replyOptional = blogReplyRepository.findById(rIdx);
        return replyOptional.map(reply -> reply.getBlog().getIdx()).orElse(null);
    }
}
