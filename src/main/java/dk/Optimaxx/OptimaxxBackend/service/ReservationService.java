package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ReservationRequest;
import dk.Optimaxx.OptimaxxBackend.DTO.ReservationResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.error.ReservationDoesNotExistException;
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
        if (!reservationRepository.existsById(id)) {
            throw new ReservationDoesNotExistException();
        }

        Reservation reservation = reservationRepository.getById(id);
        return ReservationResponse.of(reservation);
    }

    public ReservationResponse addReservation(ReservationRequest request) {
        Reservation reservation = reservationRepository.save(new Reservation(request));

        return ReservationResponse.of(reservation);
    }
}
