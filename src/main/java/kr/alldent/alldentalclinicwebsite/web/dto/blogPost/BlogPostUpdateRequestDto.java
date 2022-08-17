package kr.alldent.alldentalclinicwebsite.web.dto.blogPost;

import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPost;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BlogPostUpdateRequestDto {
    private String title;
    private String body;

    @Builder
    public BlogPostUpdateRequestDto(String title, String body){
        this.title = title;
        this.body = body;
    }

    public BlogPost toEntity(){
        return BlogPost.builder()
                .body(body)
                .title(title)
                .build();
    }
}
