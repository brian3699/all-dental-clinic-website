package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import kr.alldent.alldentalclinicwebsite.domain.post.review.ReviewRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewResponseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    ReviewRepository reviewRepository;


    @Transactional
    public ReviewResponseDto findById(Long id) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ReviewResponseDto(entity);
    }

    @Transactional
    public List<ReviewResponseDto> findAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }



}
