package kr.alldent.alldentalclinicwebsite.web.dto.comment;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import lombok.Getter;


@Getter
public class CommentResponseDto {

    private long originPostId;
    private Long id;
    private String body;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.originPostId = comment.getOriginPostId();
        this.body = comment.getBody();
    }

}
