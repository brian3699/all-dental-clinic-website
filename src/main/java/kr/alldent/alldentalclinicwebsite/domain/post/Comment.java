package kr.alldent.alldentalclinicwebsite.domain.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Comment is an entity class that defines the Comment table
 * It extends BasePostEntity and adds originPostId as a field.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BasePostEntity {

    @Column(columnDefinition = "LONG", nullable = false)
    private long originPostId;

    /**
     * updates entity's body
     * @param body the new body that will replace the old one
     */
    public void update(String body) {
        this.body = body;
    }

}
