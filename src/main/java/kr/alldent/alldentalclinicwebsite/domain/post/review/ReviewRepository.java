package kr.alldent.alldentalclinicwebsite.domain.post.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT review FROM Review review ORDER BY review.id DESC")
    List<Review> findAllDesc();
}
