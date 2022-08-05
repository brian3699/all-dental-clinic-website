package kr.alldent.alldentalclinicwebsite.domain.post;


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
@Entity
public class Comment extends BasePostEntity {

    @Column(columnDefinition = "LONG", nullable = false)
    private long originPostId;

    @Builder
    public Comment(String body, long originPostId, String userFirstName, String userLastName){
        this.body = body;
        this.originPostId = originPostId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

}
