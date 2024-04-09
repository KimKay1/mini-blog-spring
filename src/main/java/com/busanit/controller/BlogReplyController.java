package com.busanit.controller;

import com.busanit.domain.BlogReplyDTO;
import com.busanit.service.BlogReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class BlogReplyController {

    private final BlogReplyService blogReplyService;

    @PostMapping("/write")
    public void writeReply(@RequestBody BlogReplyDTO replyDTO) {

        if(replyDTO.getIdx() != null) { // reply 작성시
            blogReplyService.writeReply(replyDTO);
        } else { // reply 수정 시
            // rIdx로 해당 댓글의 부모 게시물 식별해 idx 가져옴
            Long parentPostIdx = blogReplyService.getParentPostIdx(replyDTO.getRIdx());
            replyDTO.setIdx(parentPostIdx);
            blogReplyService.writeReply(replyDTO);
        }

    }

    @PostMapping("/delete/{rIdx}")
    public void deleteReply(@PathVariable("rIdx") Long rIdx) {
        blogReplyService.deleteReply(rIdx);
    }
}
