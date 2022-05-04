package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieResponse> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return MovieResponse.of(movies);
    }

    public MovieResponse getMovieById(String id) {
        boolean movieDoesNotExist = movieRepository.existsById(id);
        //error stuff here

        Movie movie = movieRepository.getById(id);
        return MovieResponse.of(movie);
    }


}

