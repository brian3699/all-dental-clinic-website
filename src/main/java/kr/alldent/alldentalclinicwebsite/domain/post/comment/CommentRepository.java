package kr.alldent.alldentalclinicwebsite.domain.post.comment;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT comment FROM Comment comment WHERE comment.originPostId = :originPostId ORDER BY comment.id DESC")
    List<Comment> findAllPostComment(@Param("originPostId") long postId);
}
