package dk.Optimaxx.OptimaxxBackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.AccountRepository;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Transactional
class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUp(@Autowired MovieRepository movieRepository){
        Movie movie1 = Movie.builder()
                .id("myid1")
                .title("Dune")
                .tagline("It begins.")
                .category("Science Fiction, Adventure")
                .minimumAge(11)
                .duration(Duration.ofHours(2L).plusMinutes(35L))
                .rating(0.79)
                .releaseDate(LocalDate.parse("2021-09-16"))
                .picture("https://www.themoviedb.org/t/p/w1280/d5NXSklXo0qyIYkgV94XAgMIckC.jpg")
                .trailer("https://www.youtube.com/watch?v=n9xhJrPXop4")
                .build();
        Movie movie2 = Movie.builder()
                .id("myid2")
                .title("Encanto2")
                .tagline("There's a little magic in all of us ...almost all of us.")
                .category("Animation, Comedy, Family, Fantasy")
                .minimumAge(7)
                .duration(Duration.ofHours(1L).plusMinutes(42L))
                .rating(0.77)
                .releaseDate(LocalDate.parse("2021-11-25"))
                .picture("https://www.themoviedb.org/t/p/w1280/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg")
                .trailer("https://www.youtube.com/watch?v=CaimKeDcudo")
                .build();
        Movie movie3 = Movie.builder()
                .id("myid3")
                .title("Encanto3")
                .tagline("3")
                .category("Memes, Dank")
                .minimumAge(10)
                .duration(Duration.ofHours(1L).plusMinutes(42L))
                .rating(0.77)
                .releaseDate(LocalDate.parse("2021-11-25"))
                .picture("https://www.themoviedb.org/t/p/w1280/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg")
                .trailer("https://www.youtube.com/watch?v=CaimKeDcudo")
                .build();
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
    }

    @AfterAll
    public static void teardown(@Autowired MovieRepository movieRepository){
        movieRepository.deleteAll();
    }


    @Test
    void getMovies() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    void testGetMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies/myid2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void countMovies() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies/count")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        assert (result.equals("3"));
    }

    @Test
    void importMovieFromImdb() throws Exception {
        //posting the avatar movie to the database
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/api/movies/tt0499549"));
        //checking that its there
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies/tt0499549")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Avatar"));

    }
}