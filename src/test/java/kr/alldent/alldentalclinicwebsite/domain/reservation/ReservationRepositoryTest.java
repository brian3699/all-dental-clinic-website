package kr.alldent.alldentalclinicwebsite.domain.reservation;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReservationRepositoryTest {
    private static final LocalDate TODAY = LocalDate.now();

    long uid = 1L;
    Date date = Date.valueOf(TODAY);
    String time = "11:00";
    String service = "SERVICE_SCALING";
    String name = "Mickey Mouse";
    String phoneNumber = "000000000";


    @Autowired
    public ReservationRepository reservationRepository;

    @AfterEach
    public void clear(){
        reservationRepository.deleteAll();
    }

    public void addDefault(){
        reservationRepository.save(Reservation.builder()
                .uid(uid)
                .reservationDate(date)
                .reservationTime(time)
                .service(service)
                .name(name)
                .phoneNumber(phoneNumber)
                .build());
    }

    @Test
    public void testSave() {
        addDefault();

        List<Reservation> reservationList = reservationRepository.findAll();

        Reservation first = reservationList.get(0);

        Assertions.assertEquals(first.getUid(), uid, "uid is not saved correctly");
        Assertions.assertEquals(first.getReservationDate(), date, "date is not saved correctly");
        Assertions.assertEquals(first.getReservationTime(), time, "time is not saved correctly");
        Assertions.assertEquals(first.getService(), service, "service is not saved correctly");
        Assertions.assertEquals(first.getName(), name, "name is not saved correctly");
        Assertions.assertEquals(first.getPhoneNumber(), phoneNumber, "phone number is not saved correctly");
    }

    @Test
    public void testDelete(){
        addDefault();
        List<Reservation> reservationList = reservationRepository.findAll();
        Reservation firstReservation = reservationList.get(0);

        reservationRepository.delete(firstReservation);

        Assertions.assertEquals(0, reservationRepository.findAll().size(), "service failed to delete");
    }
}