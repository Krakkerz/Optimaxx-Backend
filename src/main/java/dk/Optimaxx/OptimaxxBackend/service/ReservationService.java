package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ReservationRequest;
import dk.Optimaxx.OptimaxxBackend.DTO.ReservationResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import dk.Optimaxx.OptimaxxBackend.error.ReservationDoesNotExistException;
import dk.Optimaxx.OptimaxxBackend.repository.AccountRepository;
import dk.Optimaxx.OptimaxxBackend.repository.ReservationRepository;
import dk.Optimaxx.OptimaxxBackend.repository.SeatRepository;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AccountRepository accountRepository;
    private final SeatRepository seatRepository;
    private final ShowingRepository showingRepository;

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
        Account account = accountRepository.getByEmail(request.getAccountEmail());
        Set<Seat> seats = Set.copyOf(seatRepository.findAllById(request.getSeatIds()));
        Showing showing = showingRepository.getById(request.getShowingId());

        Reservation reservation = Reservation.builder()
                .account(account)
                .seats(seats)
                .showing(showing)
                .build();

        return ReservationResponse.of(reservationRepository.save(reservation));
    }
}
