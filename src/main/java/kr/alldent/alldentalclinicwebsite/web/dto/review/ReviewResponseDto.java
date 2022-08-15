package kr.alldent.alldentalclinicwebsite.web.dto.review;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ReviewResponseDto {

        private Long id;
        private String title;
        private String body;
        private Date visitDate;

        public ReviewResponseDto(Review review){
            this.id = review.getId();
            this.title = review.getTitle();
            this.body = review.getBody();
            this.visitDate = review.getVisitDate();
        }

}
