package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ReservationResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<ReservationResponse> getAllReservations(Pageable pageable){
        List<Reservation> reservations = reservationRepository.findAll();
        return ReservationResponse.of(reservations);
    }

    public ReservationResponse getReservationById(Long id) {
        boolean reservationDoesNotExist = reservationRepository.existsById(id);
        //error stuff here

        Reservation reservation = reservationRepository.getById(id);
        return ReservationResponse.of(reservation);
    }
}
