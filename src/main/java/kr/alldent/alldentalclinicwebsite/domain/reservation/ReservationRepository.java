package kr.alldent.alldentalclinicwebsite.domain.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("SELECT reservation FROM Reservation reservation WHERE reservation.uid = :uid AND reservation.reservationDate >= :today  ORDER BY reservation.reservationDate ASC")
    List<Reservation> findByUid(@Param("uid") long uid, @Param("today") Date today);


}
