package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.SeatResponse;
import dk.Optimaxx.OptimaxxBackend.service.ShowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showings/{showingId}/seats")
@RequiredArgsConstructor
public class ShowingSeatController {
    private final ShowingService showingService;

    @GetMapping
    public List<SeatResponse> getAllSeatsByShowingId(@PathVariable Long showingId) {
        return showingService.getAllSeatsByShowingId(showingId);
    }
}
