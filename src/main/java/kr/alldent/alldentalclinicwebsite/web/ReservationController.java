package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.service.ReservationService;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentUpdateRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReservationController {
    private final ReservationService reservationService;

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

}
