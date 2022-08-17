package kr.alldent.alldentalclinicwebsite.web.dto.blogPost;

import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPost;
import lombok.Getter;


@Getter
public class BlogPostResponseDto {

    private Long id;
    private String title;
    private String body;

    public BlogPostResponseDto(BlogPost blogPost){
        this.id = blogPost.getId();
        this.title = blogPost.getTitle();
        this.body = blogPost.getBody();
    }

}
