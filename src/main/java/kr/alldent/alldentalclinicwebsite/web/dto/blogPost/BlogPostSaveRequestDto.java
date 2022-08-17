package kr.alldent.alldentalclinicwebsite.web.dto.blogPost;

import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPost;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BlogPostSaveRequestDto {
    private String title;
    private String body;
    private String name;

    @Builder
    public BlogPostSaveRequestDto(String name, String title, String body) {
        this.body = body;
        this.name = name;
        this.title = title;
    }

    public BlogPost toEntity(){
        return BlogPost.builder()
                .name(name)
                .body(body)
                .title(title)
                .build();
    }
}
