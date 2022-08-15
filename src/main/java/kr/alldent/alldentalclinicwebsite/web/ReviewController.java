package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.config.auth.dto.SessionUser;
import kr.alldent.alldentalclinicwebsite.service.ReviewService;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewResponseListDto;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@ResponseBody
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/api/review")
    public Long save(@RequestBody ReviewSaveRequestDto reviewSaveRequestDto) {
        return reviewService.save(reviewSaveRequestDto);
    }

    @PutMapping("/api/review/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReviewUpdateRequestDto reviewUpdateRequestDto) {
        return reviewService.update(id, reviewUpdateRequestDto);
    }

    @DeleteMapping("/api/review/{id}")
    public Long delete(@PathVariable Long id) {
        reviewService.delete(id);
        return id;
    }

    @GetMapping("/api/review/{id}")
    public ReviewResponseDto find(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @GetMapping("/api/review/list")
    public List<ReviewResponseListDto> findAll() {
        return reviewService.findAllDesc();
    }




}
