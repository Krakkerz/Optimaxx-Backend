package dk.Optimaxx.OptimaxxBackend.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.DTO.ImdbMovieResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import io.swagger.v3.core.util.ObjectMapperFactory;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<MovieResponse> getAllMovies(Pageable pageable){
        List<Movie> movies = movieRepository.findAll();
        return MovieResponse.of(movies);
    }

    public MovieResponse getMovieById(Long id) {
        boolean movieDoesNotExist = movieRepository.existsById(id);
        //error stuff here

        Movie movie = movieRepository.getById(id);
        return MovieResponse.of(movie);
    }


     public ImdbMovieResponse importMovieFromImdb(String imdb_id) {
        String apiKey = "k_r62acbmv";
        String apiUrl = "https://imdb-api.com/en/API/Title";
        String options = "Posters,Trailer,Ratings,";

        String requestString = "%s/%s/%s/%s".formatted(apiUrl, apiKey, imdb_id, options);

        URL requestURL = null;
        try {
            requestURL = URI.create(requestString).toURL();
        } catch (IllegalArgumentException | MalformedURLException ex) {
            // TODO: use custom exception classes
            throw new RuntimeException(ex);
        }

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ImdbMovieResponse imdbMovieResponse = null;
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

        return imdbMovieResponse;

        /* TODO:
            make ImdbMovieResponse into a Movie
            save the movie to database
            return saved movie as MovieResponse
         */

    }
}

