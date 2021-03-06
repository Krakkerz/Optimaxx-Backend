package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.ImdbMovieResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getMovies(Pageable pageable) {
        return movieService.getAllMovies(pageable);
    }

    @GetMapping("/{id}")
    public MovieResponse getMovies(@PathVariable String id){
        return movieService.getMovieById(id);
    }

    @GetMapping("/count")
    public Long countMovies (){
        return movieService.countMovies();
    }

    @PostMapping("/{imdb_id}")
    public MovieResponse importMovieFromImdb(@PathVariable String imdb_id) {
        return movieService.importMovieFromImdb(imdb_id);
    }
}
