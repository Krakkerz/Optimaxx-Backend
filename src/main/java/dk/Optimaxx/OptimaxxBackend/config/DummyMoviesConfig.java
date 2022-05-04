package dk.Optimaxx.OptimaxxBackend.config;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DummyMoviesConfig implements ApplicationRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Movie> movies = List.of(
                Movie.builder()
                        .title("Encanto")
                        .tagline("There's a little magic in all of us ...almost all of us.")
                        .category("Animation, Comedy, Family, Fantasy")
                        .minimumAge(7)
                        .duration(Duration.ofHours(1L).plusMinutes(42L))
                        .rating(0.77)
                        .releaseDate(LocalDate.parse("2021-11-25"))
                        .picture("https://www.themoviedb.org/t/p/w1280/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg")
                        .trailer("https://www.youtube.com/watch?v=CaimKeDcudo")
                        .build(),
                Movie.builder()
                        .title("Dune")
                        .tagline("It begins.")
                        .category("Science Fiction, Adventure")
                        .minimumAge(11)
                        .duration(Duration.ofHours(2L).plusMinutes(35L))
                        .rating(0.79)
                        .releaseDate(LocalDate.parse("2021-09-16"))
                        .picture("https://www.themoviedb.org/t/p/w1280/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg")
                        .trailer("https://www.youtube.com/watch?v=n9xhJrPXop4")
                        .build(),
                Movie.builder()
                        .title("The Matrix Resurrections")
                        .tagline("Return to the source.")
                        .category("Science Fiction, Action, Adventure")
                        .minimumAge(11)
                        .duration(Duration.ofHours(2L).plusMinutes(28L))
                        .rating(0.67)
                        .releaseDate(LocalDate.parse("2021-12-22"))
                        .picture("https://www.themoviedb.org/t/p/w1280/d5NXSklXo0qyIYkgV94XAgMIckC.jpg")
                        .trailer("https://www.youtube.com/watch?v=9ix7TUGVYIo")
                        .build()
                );

        movieRepository.saveAll(movies);

    }
}
