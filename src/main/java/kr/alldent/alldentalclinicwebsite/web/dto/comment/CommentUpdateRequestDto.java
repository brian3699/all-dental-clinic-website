package kr.alldent.alldentalclinicwebsite.web.dto.comment;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private String body;

    @Builder
    public CommentUpdateRequestDto(String body){
        this.body = body;
    }

    public Comment toEntity(){
        return Comment.builder()
                .body(body)
                .build();
    }
}
