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
                        .build()
                );

        movieRepository.saveAll(movies);

    }
}
