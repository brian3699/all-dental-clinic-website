package kr.alldent.alldentalclinicwebsite.service;

import kr.alldent.alldentalclinicwebsite.domain.post.comment.Comment;
import kr.alldent.alldentalclinicwebsite.domain.reservation.Reservation;
import kr.alldent.alldentalclinicwebsite.domain.reservation.ReservationRepository;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.comment.CommentUpdateRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationResponseDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationSaveRequestDto;
import kr.alldent.alldentalclinicwebsite.web.dto.reservation.ReservationUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

        reservation.update(dto.getReservationDate(), dto.getReservationTime(),dto.getService(),dto.getPhoneNumber());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        reservationRepository.delete(reservation);
    }

    //TODO: change to uid
    @Transactional
    public ReservationResponseDto findByUid(Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not in user list: id=" + id));

        return new ReservationResponseDto(reservation);
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
