package kr.alldent.alldentalclinicwebsite.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * BlogPost is an entity class that defines the BlogPost table
 * It extends BasePostEntity and adds title as a field.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BlogPost extends BasePostEntity{

    @Column(length = 500, nullable = false)
    private String title;

    /**
     * updates entity's title and body
     * @param title the new title that will replace the old one
     * @param body the new body that will replace the old one
     */
    public void update(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
