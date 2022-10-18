package kr.alldent.alldentalclinicwebsite.domain.post.comment;

import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPost;
import kr.alldent.alldentalclinicwebsite.domain.post.blogPost.BlogPostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class CommentRepositoryTest {
    /*
    long originPostId = 1;
    String body = "test body";
    String userFirstName = "test first name";
    String userLastName = "test last name";

    @Autowired
    public CommentRepository commentRepository;

    @AfterEach
    public void clear(){
        commentRepository.deleteAll();
    }

    @Test
    public void testSave() {
        commentRepository.save(Comment.builder()
                .body(body)
                //.userFirstName(userFirstName)
                //.userLastName(userLastName)
                .originPostId(originPostId)
                .build());

        List<Comment> commentList = commentRepository.findAll();

        Comment firstPost = commentList.get(0);

        Assertions.assertEquals(firstPost.getBody(), body, "body is not saved correctly");
        Assertions.assertEquals(firstPost.getOriginPostId(), originPostId, "originPostId is not saved correctly");
        //Assertions.assertEquals(firstPost.getUserFirstName(), userFirstName, "userFirstName is not saved correctly");
        //Assertions.assertEquals(firstPost.getUserLastName(), userLastName, "userLastName is not saved correctly");


    }
    */


}