package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.SeatResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.service.ShowingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/showings")
@RequiredArgsConstructor
public class ShowingController {
    private final ShowingService showingService;

    @GetMapping
    public List<ShowingResponse> getAllShowings() {
        return showingService.getAllShowings();
    }

    @GetMapping("/{id}")
    public ShowingResponse getShowingById(@PathVariable Long id) {
        return showingService.getShowingById(id);
    }

    @GetMapping("reservations/{id}")
    public List<SeatResponse> getEmptySeats(@PathVariable Long id) {return showingService.getEmptySeats(id);}
}
