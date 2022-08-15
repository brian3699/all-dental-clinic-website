package kr.alldent.alldentalclinicwebsite.web.dto.review;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class ReviewUpdateRequestDto {
    private String title;
    private String body;
    private Date visitDate;

    @Builder
    public ReviewUpdateRequestDto(Date visitDate, String title, String body){
        this.title = title;
        this.body = body;
        this.visitDate = visitDate;
    }

    public Review toEntity(){
        return Review.builder()
                .visitDate(visitDate)
                .title(title)
                .body(body)
                .build();
    }


}
