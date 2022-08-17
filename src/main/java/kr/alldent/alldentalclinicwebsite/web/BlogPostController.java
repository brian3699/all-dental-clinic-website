package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.service.BlogPostService;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@ResponseBody
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PostMapping("/api/review")
    public Long save(@RequestBody BlogPostSaveRequestDto dto) {
        return blogPostService.save(dto);
    }

    @PutMapping("/api/blog/{id}")
    public Long update(@PathVariable Long id, @RequestBody BlogPostUpdateRequestDto dto) {
        return blogPostService.update(id, dto);
    }

    @DeleteMapping("/api/blog/{id}")
    public Long delete(@PathVariable Long id) {
        blogPostService.delete(id);
        return id;
    }

    @GetMapping("/api/blog/{id}")
    public BlogPostResponseDto find(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @GetMapping("/api/blog/list")
    public List<BlogPostResponseDto> findAll() {
        return blogPostService.findAllDesc();
    }

}
