package kr.alldent.alldentalclinicwebsite.web.dto.reservation;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Service;
import lombok.Builder;

import java.sql.Date;
import java.sql.Time;

public class ReservationSaveRequestDto {

    private long uid;
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String name;
    private String phoneNumber;

    @Builder
    public ReservationSaveRequestDto(Long uid, Date reservationDate, String reservationTime, String service,
                                     String name, String phoneNumber){
        this.uid = uid;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.service = service;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public Reservation toEntity(){
        return Reservation.builder()
                .uid(uid)
                .reservationDate(reservationDate)
                .reservationTime(reservationTime)
                .service(service)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();

    }




}
