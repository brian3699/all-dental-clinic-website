package kr.alldent.alldentalclinicwebsite.domain.reservation;


import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Reservation is an entity class that defines the Reservation table.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date reservationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Service serviceType;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long phoneNumber;


    /**
     * updates entity's reservationDateTime, serviceType, firstName, lastName, and phoneNumber
     * @param reservationDateTime date and time of reservation
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param phoneNumber patient's phone number
     */
    public void update(Date reservationDateTime, Service serviceType, String firstName,
                       String lastName, Long phoneNumber) {
        this.reservationDateTime = reservationDateTime;
        this.serviceType = serviceType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}
