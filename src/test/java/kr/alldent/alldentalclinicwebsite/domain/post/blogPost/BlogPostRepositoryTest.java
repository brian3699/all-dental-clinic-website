package kr.alldent.alldentalclinicwebsite.domain.post.blogPost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BlogPostRepositoryTest {
    /**
    LocalDateTime curr = LocalDateTime.of(2022, 6, 16, 0, 0, 0);
    String title = "test title";
    String body = "test body";
    String userFirstName = "test first name";
    String userLastName = "test last name";

    @Autowired
    public BlogPostRepository blogPostRepository;

    @AfterEach
    public void clear(){
        blogPostRepository.deleteAll();
    }

    @Test
    public void testSave() {
        blogPostRepository.save(BlogPost.builder()
                .body(body)
                .name(userLastName)
                .title(title)
                .build());

        List<BlogPost> blogPostList = blogPostRepository.findAll();

        BlogPost firstPost = blogPostList.get(0);

        Assertions.assertEquals(firstPost.getBody(), body, "body is not saved correctly");
        Assertions.assertEquals(firstPost.getTitle(), title, "title is not saved correctly");


    }

    @Test
    public void testTimeTracking() {
        blogPostRepository.save(BlogPost.builder()
                .body(body)
                .name(userLastName)
                .title(title)
                .build());

        List<BlogPost> blogPostList = blogPostRepository.findAll();

        BlogPost firstPost = blogPostList.get(0);

        Assertions.assertTrue(firstPost.getCreatedDateTime() == null);

    }
    **/



}