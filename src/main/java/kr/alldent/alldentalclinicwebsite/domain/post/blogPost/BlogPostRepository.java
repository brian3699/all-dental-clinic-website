package kr.alldent.alldentalclinicwebsite.domain.post.blogPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    @Query("SELECT blogPost FROM BlogPost blogPost ORDER BY blogPost.id DESC")
    List<BlogPost> findAllDesc();

}
