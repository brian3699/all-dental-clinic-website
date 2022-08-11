package kr.alldent.alldentalclinicwebsite.domain.post.comment;


import kr.alldent.alldentalclinicwebsite.domain.post.BasePostEntity;
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
@Entity
public class Comment extends BasePostEntity {

    @Column
    private long originPostId;

    @Builder
    public Comment(String body, String name, long originPostId){
        this.originPostId = originPostId;
        this.body = body;
        this.name = name;
    }

    /**
     * updates entity's body
     * @param body the new body that will replace the old one
     */
    public void update(String body) {
        this.body = body;
    }

}
