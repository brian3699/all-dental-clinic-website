package kr.alldent.alldentalclinicwebsite.domain.post;

import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
public abstract class BasePostEntity extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    protected String body;

    protected String name;

}

