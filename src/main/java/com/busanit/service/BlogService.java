package com.busanit.service;

import com.busanit.domain.BlogDTO;
import com.busanit.entity.Blog;
import com.busanit.repository.BlogReplyRepository;
import com.busanit.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final BlogReplyRepository blogReplyRepository;

    // Entity -> DTO 변환
    public BlogDTO toDTO(Blog blog) {
        return BlogDTO.builder()
                .idx(blog.getIdx())
                .title(blog.getTitle())
                .content(blog.getContent())
                .blogReplyList(blog.getBlogReplyList())
                .replyCnt(blogReplyRepository.countByBlog_Idx(blog.getIdx()))
                .build();
    }

    public List<BlogDTO> getBlogList() {
        List<Blog> blogList = blogRepository.findAllByOrderByIdxDesc();

        return blogList.stream().map(blog -> toDTO(blog)).collect(Collectors.toList());
    }

    public List<BlogDTO> getBlogSearchList(String searchTerm) {
        List<Blog> blogList = blogRepository.findByTitleContaining(searchTerm);

        return blogList.stream().map(blog -> toDTO(blog)).collect(Collectors.toList());
    }

    public BlogDTO getBlog(Long idx) {
        return toDTO(blogRepository.findById(idx).orElseThrow(() -> new NullPointerException("blog null")));
    }

    public void writeBlog(BlogDTO dto) {
        Blog blog = Blog.toEntity(dto);

        blogRepository.save(blog);
    }

    public void deleteBlog(Long idx) {
        blogRepository.deleteById(idx);
    }
}
