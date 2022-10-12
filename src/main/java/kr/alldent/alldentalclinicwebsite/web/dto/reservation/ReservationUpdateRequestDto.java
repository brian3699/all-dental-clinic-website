package kr.alldent.alldentalclinicwebsite.web.dto.reservation;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Service;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;


@Getter
public class ReservationUpdateRequestDto {
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String phoneNumber;

    @Builder
    public ReservationUpdateRequestDto(Date reservationDate, String reservationTime, String service, String phoneNumber){
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.service = service;
        this.phoneNumber = phoneNumber;

    }

}
