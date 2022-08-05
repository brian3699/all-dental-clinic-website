package kr.alldent.alldentalclinicwebsite.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Class BaseEntity records the time an entity has been created or modified
 * It will be extended by other entities that needs this feature.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate // automatically saves the time entity has been created
    protected LocalDateTime createdDateTime;


    @LastModifiedBy // automatically saves the time the entity has been modified
    protected LocalDateTime modifiedDateTime;


    /**
     * This method will return the latest time the entity has been modified or created
     * @return modified or created dateTime
     */
    public LocalDateTime getModifiedDate(){
        // Return created time if the entity has never been modified
        if(modifiedDateTime == null) return createdDateTime;

        // Return modified date if the entity has been modified
        return modifiedDateTime;

    }
}
