package com.busanit.controller;

import com.busanit.domain.BlogDTO;
import com.busanit.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogService blogService;

    @GetMapping("/list")
    public List<BlogDTO> getBlogList(@RequestParam(defaultValue = "") String searchTerm) {

        if(searchTerm.isEmpty()) {
            return blogService.getBlogList();
        } else {
            return blogService.getBlogSearchList(searchTerm);
        }
    }

    @GetMapping("/get/{idx}")
    public BlogDTO getBlog(@PathVariable("idx") Long idx) {

        return blogService.getBlog(idx);
    }

    @PostMapping("/write")
    public void writeBlog(@RequestBody BlogDTO blogDTO) {
        blogService.writeBlog(blogDTO);
    }

    @PostMapping("/delete/{idx}")
    public void deleteBlog(@PathVariable("idx") Long idx) {
        blogService.deleteBlog(idx);
    }
}
