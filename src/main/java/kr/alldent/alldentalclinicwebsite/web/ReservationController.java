package kr.alldent.alldentalclinicwebsite.web;


/*

    private final BlogPostService blogPostService;

    @PostMapping("/api/blog")
    public Long save(@RequestBody BlogPostSaveRequestDto dto) {
        return blogPostService.save(dto);
    }

    @PutMapping("/api/blog/{id}")
    public Long update(@PathVariable Long id, @RequestBody BlogPostUpdateRequestDto dto) {
        return blogPostService.update(id, dto);
    }

    @DeleteMapping("/api/blog/{id}")
    public Long delete(@PathVariable Long id) {
        blogPostService.delete(id);
        return id;
    }

    @GetMapping("/api/blog/{id}")
    public BlogPostResponseDto find(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @GetMapping("/api/blog/list")
    public List<BlogPostResponseDto> findAll() {
        return blogPostService.findAllDesc();
    }

 */

import kr.alldent.alldentalclinicwebsite.service.ReservationService;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@ResponseBody
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/api/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto dto){
        return reservationService.save(dto);
    }
}
