package dk.Optimaxx.OptimaxxBackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@NoArgsConstructor
@Transactional

class MovieControllerTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Movie movie1;

    @BeforeAll
    public static void setup(@Autowired MovieRepository movieRepository){
        movie1 = Movie.builder()
                .id("1")
                .category("horror")
                .picture("flot billede")
                .rating(5.0)
                .trailer("sej trailer")
                .duration(Duration.ofMinutes(1200))
                .build();

        movieRepository.save(movie1);
    }

    @AfterAll
    public static void tearDown(@Autowired MovieRepository movieRepository) {
        movieRepository.deleteAll();;
    }



    @Test
    void testGetMovies() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }


    @Test
    void countMovies() {
    }

    @Test
    void importMovieFromImdb() {
    }
}