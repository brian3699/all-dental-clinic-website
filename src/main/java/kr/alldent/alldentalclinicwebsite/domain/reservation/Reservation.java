package kr.alldent.alldentalclinicwebsite.domain.reservation;


import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @Column(nullable = false)
    private long uid;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private String reservationTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Service service;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;


    /**
     * updates entity's reservationDateTime, serviceType, firstName, lastName, and phoneNumber
     * @param reservationDate date of reservation
     * @param reservationTime time of reservation
     * @param phoneNumber patient's phone number
     */
    public void update(Date reservationDate, String reservationTime, String service, String phoneNumber) {

        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.service = Service.valueOf(service);
        this.phoneNumber = phoneNumber;

    }



    @Builder
    public Reservation(Date reservationDate, Long uid, String reservationTime, String service, String name, String phoneNumber){
        this.reservationDate = reservationDate;
        this.uid = uid;
        this.reservationTime = reservationTime;
        this.service = Service.valueOf(service);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getService(){
        return service.getKey();
    }


}
