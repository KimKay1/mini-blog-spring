package com.busanit.controller;

import com.busanit.domain.BlogReplyDTO;
import com.busanit.service.BlogReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class BlogReplyController {

    private final BlogReplyService blogReplyService;

    @PostMapping("/write")
    public void writeReply(@RequestBody BlogReplyDTO replyDTO) {
        blogReplyService.writeReply(replyDTO);
    }

}
