package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import kr.alldent.alldentalclinicwebsite.domain.post.comment.CommentRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public Long save(CommentSaveRequestDto dto) {
        return commentRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        comment.update(commentUpdateRequestDto.getBody());
        return id;
    }


    @Transactional
    public void delete (Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        commentRepository.delete(comment);
    }

    @Transactional
    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        return new CommentResponseDto(comment);
    }

    @Transactional
    public List<CommentResponseDto> findAllCommentOfPost(Long originPostId) {
        try {
            List<CommentResponseDto> dtoList = new ArrayList<>();
            for (Comment comment : commentRepository.findAllPostComment(originPostId)) {
                dtoList.add(new CommentResponseDto(comment));
            }
            return dtoList;
        } catch (Exception e){
            return null;
        }

    }

}
