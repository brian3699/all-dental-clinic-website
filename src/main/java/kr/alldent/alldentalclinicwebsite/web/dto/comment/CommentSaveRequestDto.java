package kr.alldent.alldentalclinicwebsite.web.dto.comment;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private long originPostId;
    private String body;
    private String name;

    @Builder
    public CommentSaveRequestDto(Long originPostId, String name, String body) {
        this.body = body;
        this.name = name;
        this.originPostId = originPostId;
    }

    public Comment toEntity(){
        return Comment.builder()
                .originPostId(originPostId)
                .name(name)
                .body(body)
                .build();
    }
}
