package kr.alldent.alldentalclinicwebsite.web.dto;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class ReviewSaveRequestDto {

    private String title;
    private String body;
    private String name;
    private Date visitDate;

    @Builder
    public ReviewSaveRequestDto(Date visitDate, String name,String title, String body) {
        this.title = title;
        this.body = body;
        this.name = name;
        this.visitDate = visitDate;
    }

    public Review toEntity(){
        return Review.builder()
                .name(name)
                .title(title)
                .body(body)
                .visitDate(visitDate)
                .build();
    }
}
