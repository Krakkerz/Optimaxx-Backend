package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin
@AllArgsConstructor
public class MovieController {
    //add stuff here
    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovies(@PathVariable String id){
        return movieService.getMovieById(id);
    }
}
