package kr.alldent.alldentalclinicwebsite.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import kr.alldent.alldentalclinicwebsite.domain.post.review.ReviewRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private MockMvc mvc;
    private final String TITLE = "title";
    private final String BODY = "body";
    private final String NAME = "name";
    private final Date VISIT_DATE = Date.valueOf("2022-06-16");
    private final Date VISIT_DATE2 = Date.valueOf("2022-06-17");
    private final String URL = "http://localhost:" + port + "/api/review";


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void beforeEach() {
        mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void afterEach() {
        reviewRepository.deleteAll();
    }


    @Test
    @WithMockUser(roles="USER")
    public void testSave() throws Exception {
        //input data
        ReviewSaveRequestDto dto = ReviewSaveRequestDto.builder()
                .title(TITLE)
                .body(BODY)
                .name(NAME)
                .visitDate(VISIT_DATE)
                .build();

        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                        .andExpect(status().isOk());

        //check result
        List<Review> all = reviewRepository.findAll();
        assertEquals(all.get(0).getTitle(), TITLE);
        assertEquals(all.get(0).getBody(), BODY);
        assertEquals(all.get(0).getVisitDate(), VISIT_DATE);
    }


    @Test
    public void testUpdate() throws Exception {
        Review original = reviewRepository.save(Review.builder()
                .visitDate(VISIT_DATE)
                .title(TITLE)
                .body(BODY)
                .build());


        ReviewUpdateRequestDto dtoUpdate = ReviewUpdateRequestDto.builder()
                .visitDate(VISIT_DATE2)
                .title(TITLE+1)
                .body(BODY+1)
                .build();

        mvc.perform(put(URL+"/" + original.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dtoUpdate)))
                .andExpect(status().isOk());

        List<Review> all = reviewRepository.findAll();

        //check result
        assertEquals(all.get(0).getTitle(), TITLE+1);
        assertEquals(all.get(0).getBody(), BODY+1);
        assertEquals(all.get(0).getVisitDate(), VISIT_DATE2);
    }

    @Test
    public void testDelete() throws Exception {
        //input data
        ReviewSaveRequestDto dto = ReviewSaveRequestDto.builder()
                .title(TITLE)
                .body(BODY)
                .name(NAME)
                .visitDate(VISIT_DATE)
                .build();

        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk());
        List<Review> all = reviewRepository.findAll();

        mvc.perform(delete(URL +"/"+ all.get(0).getId()));

        //check result

        assertEquals(reviewRepository.findAll().size(), 0);
    }




}