package kr.alldent.alldentalclinicwebsite.web.dto.reservation;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Service;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;
import java.sql.Time;

public class ReservationResponseDto {

    private Long uid;
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String name;
    private String phoneNumber;


    public ReservationResponseDto(Reservation reservation){
        this.uid = reservation.getUid();
        this.reservationDate = reservation.getReservationDate();
        this.reservationTime = reservation.getReservationTime();
        this.service = reservation.getService();
        this.name = reservation.getName();
        this.phoneNumber = reservation.getPhoneNumber();
    }

}
