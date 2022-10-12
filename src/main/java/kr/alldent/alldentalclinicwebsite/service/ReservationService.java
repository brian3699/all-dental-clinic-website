package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.review.Review;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.ReservationRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationResponseListDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationUpdateRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional
    public Long save(ReservationSaveRequestDto dto){
        return reservationRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReservationUpdateRequestDto dto){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        reservation.update(dto.getReservationDate(), dto.getReservationTime(),dto.getService(), dto.getPhoneNumber());
        return id;
    }


        @Transactional
    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        reservationRepository.delete(reservation);
    }

    @Transactional
    public List<ReservationResponseListDto> findByUid(Long uid){
        Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            List<ReservationResponseListDto> dtoList = new ArrayList<>();
            for (Reservation reservation : reservationRepository.findByUid(uid, today)) {
                dtoList.add(new ReservationResponseListDto(reservation));
            }
            return dtoList;
        } catch (Exception e){
            return null;
        }
    }

    @Transactional
    public ReservationResponseDto findById(Long id) {
        Reservation entity = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list:" + id));

        return new ReservationResponseDto(entity);
    }



}

/*
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public List<CommentResponseDto> findAllCommentOfPost(Long originPostId) {
        try {
            List<CommentResponseDto> dtoList = new ArrayList<>();
            for (Comment comment : commentRepository.findAllPostComment(originPostId)) {
                dtoList.add(new CommentResponseDto(comment));
            }
            return dtoList;
        } catch (Exception e){
            return null;
        }

    }



}
 */
