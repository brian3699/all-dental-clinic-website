package kr.alldent.alldentalclinicwebsite.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testLoadMain() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertTrue((body).contains("올치과"));
    }

    @Test
    public void testLoadReservation(){
        String body = this.restTemplate.getForObject("/reservation", String.class);
        assertTrue((body).contains("reservation"));
    }

    @Test
    public void testLoadReview(){
        String body = this.restTemplate.getForObject("/review", String.class);
        assertTrue((body).contains("리뷰"));
    }


}

