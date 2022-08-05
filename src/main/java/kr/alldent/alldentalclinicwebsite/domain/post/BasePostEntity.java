package kr.alldent.alldentalclinicwebsite.domain.post;

import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Class BasePostEntity is an abstract entity class that defines the basic fields of a post.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@Entity
public abstract class BasePostEntity extends BaseEntity {


    @Id // Priority key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    protected String body;

    protected String userFirstName;
    protected String userLastName;


    @Builder // makes this a builder pattern class
    public BasePostEntity(String body, String userFirstName, String userLastName){
        this.body = body;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;

    }

    /**
     * updates entity's body
     * @param body
     */
    public void update(String body) {
        this.body = body;
    }
}

