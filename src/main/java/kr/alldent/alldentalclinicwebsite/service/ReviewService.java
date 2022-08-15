package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import kr.alldent.alldentalclinicwebsite.domain.post.review.ReviewRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewResponseListDto;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Long save(ReviewSaveRequestDto requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReviewUpdateRequestDto reviewUpdateRequestDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        review.update(reviewUpdateRequestDto.getVisitDate(), reviewUpdateRequestDto.getTitle(), reviewUpdateRequestDto.getBody());

        return id;
    }


    @Transactional
    public void delete (Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        reviewRepository.delete(review);
    }

    @Transactional
    public ReviewResponseDto findById(Long id) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        return new ReviewResponseDto(entity);
    }

    @Transactional
    public List<ReviewResponseListDto> findAllDesc() {
        try {
            List<ReviewResponseListDto> dtoList = new ArrayList<>();
            for (Review review : reviewRepository.findAllDesc()) {
                dtoList.add(new ReviewResponseListDto(review));
            }
            return dtoList;
        } catch (Exception e){
            return null;
        }
    }




}
