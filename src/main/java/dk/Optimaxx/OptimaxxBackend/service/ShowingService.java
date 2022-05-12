package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.SeatResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import dk.Optimaxx.OptimaxxBackend.repository.ReservationRepository;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShowingService {
    private final ShowingRepository showingRepository;
    private final ReservationRepository reservationRepository;

    public List<ShowingResponse> getAllShowings() {
        return ShowingResponse.of(showingRepository.findAll());
    }

    public ShowingResponse getShowingById(Long id) {
        // TODO: Check id exists and throw custom exception if needed
        return ShowingResponse.of(showingRepository.getById(id));
    }

    public List<SeatResponse> getEmptySeats(Long id) {
        ShowingResponse showingResponse = getShowingById(id);
        ShowingResponse.of((Showing) reservationRepository.findByShowingId(id));


        // TODO: compare and exclude with reserved seats somewhere, but where? ;-;
        return null; // SeatResponse.of(showingResponse.getRoom()  .getSeats());
    }

    public List<SeatResponse> getAllSeatsByShowingId(Long id) {
        Showing showing = showingRepository.getById(id);

        List<Seat> unknownSeats = showing.getRoom().getSeats().stream().toList();

        List<Long> reservedSeatIds = showing.getReservations()
                .stream()
                .map(Reservation::getSeats)
                .flatMap(Collection::stream)
                .map(Seat::getId)
                .toList();

        List<SeatResponse> knownSeatResponses = unknownSeats.stream()
                .map(SeatResponse::of)
                .peek(seatResponse -> {
                    if (reservedSeatIds.contains(seatResponse.getId())) { seatResponse.setReserved(true); }
                })
                .toList();

        return knownSeatResponses;
    }


}
