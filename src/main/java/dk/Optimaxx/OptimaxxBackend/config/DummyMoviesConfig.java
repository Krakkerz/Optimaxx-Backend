package dk.Optimaxx.OptimaxxBackend.config;

import dk.Optimaxx.OptimaxxBackend.entity.*;
import dk.Optimaxx.OptimaxxBackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DummyMoviesConfig implements ApplicationRunner {
    private final MovieRepository movieRepository;
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Movie> movies = List.of(
                Movie.builder()
                        .id("myid1")
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
                        .id("myid2")
                        .title("Dune")
                        .tagline("It begins.")
                        .category("Science Fiction, Adventure")
                        .minimumAge(11)
                        .duration(Duration.ofHours(2L).plusMinutes(35L))
                        .rating(0.79)
                        .releaseDate(LocalDate.parse("2021-09-16"))
                        .picture("https://www.themoviedb.org/t/p/w1280/d5NXSklXo0qyIYkgV94XAgMIckC.jpg")
                        .trailer("https://www.youtube.com/watch?v=n9xhJrPXop4")
                        .build(),
                Movie.builder()
                        .id("myid3")
                        .title("The Matrix Resurrections")
                        .tagline("Return to the source.")
                        .category("Science Fiction, Action, Adventure")
                        .minimumAge(11)
                        .duration(Duration.ofHours(2L).plusMinutes(28L))
                        .rating(0.67)
                        .releaseDate(LocalDate.parse("2021-12-22"))
                        .picture("https://www.themoviedb.org/t/p/w1280/8c4a8kE7PizaGQQnditMmI1xbRp.jpg")
                        .trailer("https://www.youtube.com/watch?v=9ix7TUGVYIo")
                        .build()
                );

        movieRepository.saveAll(movies);

        Account testman1 = Account.builder()
                .email("testman1@email.com")
                .name("Test Johnson")
                .phoneNumber("88888888")
                .build();

        accountRepository.save(testman1);

        Cinema cinema1 = Cinema.builder()
                .name("CineMark")
                .Location("Mark's baghave")
                .build();

        cinemaRepository.save(cinema1);

        Room room1 = Room.builder()
                .cinema(cinema1)
                .description("det er ikke så meget et rum og mere et stykke græs")
                .build();
        roomRepository.save(room1);

        //pls make me pretty
        int n = 0;
        while(n<= 10) {
            for (int i = 1; i<=20;i++) {
                Seat CurSeat = Seat.builder()
                        .room(room1)
                        .type("standard")
                        .seatNumber(i)
                        .seatRow(n)
                        .build();

                seatRepository.save(CurSeat);
            }
            n++;
        }

    }
}
