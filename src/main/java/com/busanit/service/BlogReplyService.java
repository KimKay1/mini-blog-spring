package com.busanit.service;

import com.busanit.domain.BlogReplyDTO;
import com.busanit.entity.BlogReply;
import com.busanit.repository.BlogReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogReplyService {

    private final BlogReplyRepository blogReplyRepository;

    public void writeReply(BlogReplyDTO dto) {
        BlogReply blogReply = BlogReply.toEntity(dto);

        blogReplyRepository.save(blogReply);
    }
}
