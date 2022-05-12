package dk.Optimaxx.OptimaxxBackend.api;


import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.service.MovieService;
import dk.Optimaxx.OptimaxxBackend.service.MovieShowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/movies/{movieId}/showings")
public class MovieShowingController {
    private final MovieShowingService movieShowingService;

    @GetMapping
    public List<ShowingResponse> getAllShowingsByMovieId(@PathVariable String movieId) {
        return movieShowingService.getAllShowingsByMovieId(movieId);
    }

    @GetMapping("/groupByDate")
    public Map<LocalDate, List<ShowingResponse>> getAllShowingsByMovieIdGroupByDate(@PathVariable String movieId) {
        return movieShowingService.getAllShowingsByMovieIdGroupByDate(movieId);
    }
}
