package kr.alldent.alldentalclinicwebsite.web.dto;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;

import java.sql.Date;

public class ReviewResponseListDto {
    private Long id;
    private String title;
    private String body;
    private Date visitDate;

    public ReviewResponseListDto(Review review){
        this.id = review.getId();
        this.title = review.getTitle();
        this.body = review.getBody();
        this.visitDate = review.getVisitDate();
    }

}
