package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.service.CommentService;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@ResponseBody
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comment")
    public Long save(@RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.save(commentSaveRequestDto);
    }

    @PutMapping("/api/comment/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
        return commentService.update(id, commentUpdateRequestDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public Long delete(@PathVariable Long id) {
        commentService.delete(id);
        return id;
    }

    @GetMapping("/api/comment/{id}")
    public CommentResponseDto find(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @GetMapping("/api/comment/list/{id}")
    public List<CommentResponseDto> findAll(@PathVariable Long id) {
        return commentService.findAllCommentOfPost(id);
    }

}
