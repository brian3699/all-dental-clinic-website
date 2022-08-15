package kr.alldent.alldentalclinicwebsite.domain.post.review;

import kr.alldent.alldentalclinicwebsite.domain.post.BasePostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Review is an entity class that defines the Review table
 * It extends BasePostEntity and adds fields visitDate and title.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@Entity
public class Review extends BasePostEntity {

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "DATE")
    private Date visitDate;

    @Builder
    public Review(Date visitDate, String name,String title, String body){
        this.name = name;
        this.title = title;
        this.body = body;
        this.visitDate = visitDate;
    }

    /**
     * updates entity's title, visitDate, and body
     * @param title the new title that will replace the old one
     * @param visitDate the new visitDate that will replace the old one
     * @param body the new body that will replace the old one
     */
    public void update(Date visitDate, String title, String body) {
        this.title = title;
        this.visitDate = visitDate;
        this.body = body;
    }

}
