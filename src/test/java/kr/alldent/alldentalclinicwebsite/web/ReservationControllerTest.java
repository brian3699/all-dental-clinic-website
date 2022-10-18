package kr.alldent.alldentalclinicwebsite.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.ReservationRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import org.junit.After;
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
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest {
    /*
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

    @After
    public void resetRepository(){
        reservationRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void testSave() throws Exception {
        String uid = "1";
        String reservationDate = "2022-12-25";
        String reservationTime = "11:00";
        String service = "First visit";
        String name = "Young";
        String phoneNumber = "01043420305";

        ReservationSaveRequestDto saveDto = ReservationSaveRequestDto.builder()
                .uid(uid)
                .reservationDate(reservationDate)
                .reservationTime(reservationTime)
                .service(service)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();

        mvc.perform(post("http://localhost:" + port + "/api/reservation")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(saveDto)))
                .andExpect(status().isOk());




        ;

        List<Reservation> list = reservationRepository.findAll();
        assertEquals(list.get(0).getUid(), uid);
        assertEquals(list.get(0).getReservationDate(), reservationDate);
        assertEquals(list.get(0).getReservationTime(), reservationTime);
        assertEquals(list.get(0).getService(), service);
        assertEquals(list.get(0).getName(), name);
        assertEquals(list.get(0).getPhoneNumber(), phoneNumber);

    }

     */



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