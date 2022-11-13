package kr.alldent.alldentalclinicwebsite.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.ReservationRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationUpdateRequestDto;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest {
    private static final LocalDate TODAY = LocalDate.now();
    private final long uid = 1L;
    private final Date date = Date.valueOf(TODAY);
    private final String time = "11:00";
    private final String service = "SERVICE_SCALING";
    private final String name = "Mickey Mouse";
    private final String phoneNumber = "000000000";
    private final long uid2 = 2L;
    private final Date date2 = Date.valueOf(Date.valueOf(TODAY).toLocalDate().plusDays(1));
    private final String time2 = "12:00";
    private final String service2 = "SERVICE_WISDOM_TEETH";
    private final String name2 = "Princess";
    private final String phoneNumber2 = "1111111111";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void resetRepository() {
        reservationRepository.deleteAll();
    }


    public long saveDefault() throws Exception {

        Reservation reservation = reservationRepository.save(Reservation.builder()
                .uid(uid)
                .reservationDate(date)
                .reservationTime(time)
                .service(service)
                .name(name)
                .phoneNumber(phoneNumber)
                .build());

        return reservation.getId();


    }
    @Test
    @WithMockUser(roles="USER")
    public void testSave() throws Exception {
        ReservationSaveRequestDto saveDto = ReservationSaveRequestDto.builder()
                .uid(uid)
                .reservationDate(date)
                .reservationTime(time)
                .service(service)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();

        mvc.perform(post("http://localhost:" + port + "/api/reservation")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(saveDto)))
                .andExpect(status().isOk());

        List<Reservation> list = reservationRepository.findAll();
        assertEquals(list.get(0).getUid(), uid);
        assertEquals(list.get(0).getReservationDate(), date);
        assertEquals(list.get(0).getReservationTime(), time);
        assertEquals(list.get(0).getService(), service);
        assertEquals(list.get(0).getName(), name);
        assertEquals(list.get(0).getPhoneNumber(), phoneNumber);

    }

    @Test
    @WithMockUser(roles="USER")
    public void testUpdate() throws Exception{
        long reservationId = saveDefault();

        ReservationUpdateRequestDto updateRequestDto = ReservationUpdateRequestDto.builder()
                .reservationDate(date2)
                .reservationTime(time2)
                .phoneNumber(phoneNumber2)
                .service(service2)
                .build();

        mvc.perform(put("http://localhost:" + port + "/api/reservation/" + reservationId)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(updateRequestDto)))
                .andExpect(status().isOk());


        List<Reservation> list = reservationRepository.findAll();
        assertEquals(list.get(0).getUid(), uid);
        assertEquals(list.get(0).getReservationDate(), date2);
        assertEquals(list.get(0).getReservationTime(), time2);
        assertEquals(list.get(0).getService(), service2);
        assertEquals(list.get(0).getName(), name);
        assertEquals(list.get(0).getPhoneNumber(), phoneNumber2);
    }

    @Test
    @WithMockUser(roles="USER")
    public void testDelete() throws Exception{
        long reservationId = saveDefault();

        mvc.perform(delete("http://localhost:" + port + "/api/reservation/" + reservationId));

        List<Reservation> list = reservationRepository.findAll();
        assertEquals(0, list.size(), "Reservation not deleted");

    }
}
/*
response
    private Long id;
    private Long uid;
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String name;
    private String phoneNumber;
save
        private long uid;
    private Date reservationDate;
    private String reservationTime;
    private String service;
    private String name;
    private String phoneNumber;
update
        private Date reservationDate;
    private String reservationTime;
    private String service;
    private String phoneNumber;



    @PostMapping("/api/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto dto){
        return reservationService.save(dto);
    }

    @PutMapping("/api/reservation/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
        return reservationService.update(id, reservationUpdateRequestDto);
    }



    @DeleteMapping("/api/reservation/{id}")
    public Long delete(@PathVariable Long id){
        reservationService.delete(id);
        return id;
    }

 */