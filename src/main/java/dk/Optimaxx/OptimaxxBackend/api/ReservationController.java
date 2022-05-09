package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.ReservationRequest;
import dk.Optimaxx.OptimaxxBackend.DTO.ReservationResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationResponse> getMovies(Pageable pageable){
        return reservationService.getAllReservations(pageable);
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservations(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public ReservationResponse addReservation(ReservationRequest request) {
        return reservationService.addReservation(request);
    }


}
