package kr.alldent.alldentalclinicwebsite.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Review is an entity class that defines the Review table
 * It extends BasePostEntity and adds visitDate and title as a field.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review extends BasePostEntity{

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "LONG", nullable = false)
    private String visitDate;

    /**
     * updates entity's title, visitDate, and body
     * @param title the new title that will replace the old one
     * @param visitDate the new visitDate that will replace the old one
     * @param body the new body that will replace the old one
     */
    public void update(String title, String visitDate, String body) {
        this.title = title;
        this.visitDate = visitDate;
        this.body = body;
    }

}
