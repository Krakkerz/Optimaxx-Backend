package dk.Optimaxx.OptimaxxBackend.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.DTO.ImdbMovieResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.error.MovieDoesNotExistException;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<MovieResponse> getAllMovies(Pageable pageable) {
        List<Movie> movies = movieRepository.findAll();
        return MovieResponse.of(movies);
    }

    public MovieResponse getMovieById(String id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieDoesNotExistException();
        }


        Movie movie = movieRepository.getById(id);
        return MovieResponse.of(movie);
    }
    public Long countMovies(){
        return movieRepository.count();
    }


    public MovieResponse importMovieFromImdb(String imdb_id) {
        String apiKey = "k_bwci9c2f";
        String apiUrl = "https://imdb-api.com/en/API/Title";
        // All the options are: "FullActor,FullCast,Posters,Images,Trailer,Ratings,Wikipedia,"
        String options = "Images,Trailer,";

        String requestString = "%s/%s/%s/%s".formatted(apiUrl, apiKey, imdb_id, options);

        URL requestURL;
        try {
            requestURL = URI.create(requestString).toURL();
        } catch (IllegalArgumentException | MalformedURLException ex) {
            // TODO: use custom exception classes
            throw new RuntimeException(ex);
        }

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ImdbMovieResponse imdbMovieResponse;
        try (JsonParser parser = mapper.createParser(requestURL)) {
            imdbMovieResponse = parser.readValueAs(ImdbMovieResponse.class);
        } catch (IOException ex) {
            // TODO: use custom exception classes
            throw new RuntimeException(ex);
        }

        if (imdbMovieResponse == null) {
            // TODO: use custom exception classes
            throw new RuntimeException();
        }

        // TODO: Handle if movie already exists
        return MovieResponse.of(movieRepository.save(imdbMovieResponse.toMovie()));
    }
}

