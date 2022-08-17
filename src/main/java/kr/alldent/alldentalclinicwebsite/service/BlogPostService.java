package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPost;
import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPostRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.blogPost.BlogPostUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;


    @Transactional
    public Long save(BlogPostSaveRequestDto dto) {
        return blogPostRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BlogPostUpdateRequestDto dto) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        blogPost.update(dto.getTitle(), dto.getBody());

        return id;
    }


    @Transactional
    public void delete (Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        blogPostRepository.delete(blogPost);
    }

    @Transactional
    public BlogPostResponseDto findById(Long id) {
        BlogPost entity = blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        return new BlogPostResponseDto(entity);
    }

    @Transactional
    public List<BlogPostResponseDto> findAllDesc() {
        try {
            List<BlogPostResponseDto> dtoList = new ArrayList<>();
            for (BlogPost blogPost : blogPostRepository.findAllDesc()) {
                dtoList.add(new BlogPostResponseDto(blogPost));
            }
            return dtoList;
        } catch (Exception e){
            return null;
        }
    }


}
