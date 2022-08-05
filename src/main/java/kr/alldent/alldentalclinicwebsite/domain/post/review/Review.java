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
@AllArgsConstructor
@Entity
public class Review extends BasePostEntity {

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date visitDate;

    /**
     * updates entity's title, visitDate, and body
     * @param title the new title that will replace the old one
     * @param visitDate the new visitDate that will replace the old one
     * @param body the new body that will replace the old one
     */
    public void update(String title, Date visitDate, String body) {
        this.title = title;
        this.visitDate = visitDate;
        this.body = body;
    }

}
