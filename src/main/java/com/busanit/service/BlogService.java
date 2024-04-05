package com.busanit.service;

import com.busanit.domain.BlogDTO;
import com.busanit.entity.Blog;
import com.busanit.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<BlogDTO> getBlogList() {
        List<Blog> blogList = blogRepository.findAllByOrderByIdxDesc();

        return blogList.stream().map(blog -> BlogDTO.toDTO(blog)).collect(Collectors.toList());
    }

    public BlogDTO getBlog(Long idx) {
        return BlogDTO.toDTO(blogRepository.findById(idx).orElseThrow(() -> new NullPointerException("blog null")));
    }

    public void writeBlog(BlogDTO dto) {
        Blog blog = Blog.toEntity(dto);

        blogRepository.save(blog);
    }

    public void deleteBlog(Long idx) {
        blogRepository.deleteById(idx);
    }
}
