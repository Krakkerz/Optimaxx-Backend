package dk.Optimaxx.OptimaxxBackend.api;


import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.service.MovieService;
import dk.Optimaxx.OptimaxxBackend.service.MovieShowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies/{movieId}/showings")
public class MovieShowingController {
    private final MovieShowingService movieShowingService;

    @GetMapping
    public List<ShowingResponse> getAllShowingsByMovieId(@PathVariable String movieId) {
        return movieShowingService.getAllShowingsByMovieId(movieId);
    }

}
