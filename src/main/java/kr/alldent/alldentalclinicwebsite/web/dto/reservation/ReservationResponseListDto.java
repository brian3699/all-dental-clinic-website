package kr.alldent.alldentalclinicwebsite.web.dto.reservation;

import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Service;

import java.sql.Date;

public class ReservationResponseListDto {

    private Long id;
    private Long uid;
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String name;
    private String phoneNumber;


    public ReservationResponseListDto(Reservation reservation){
        this.id = reservation.getId();
        this.uid = reservation.getUid();
        this.reservationDate = reservation.getReservationDate();
        this.reservationTime = reservation.getReservationTime();
        this.service = Service.valueOf(reservation.getService()).getDescription();
        this.name = reservation.getName();
        this.phoneNumber = reservation.getPhoneNumber();
    }

}
