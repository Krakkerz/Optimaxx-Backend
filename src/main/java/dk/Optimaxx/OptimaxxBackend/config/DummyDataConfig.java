package dk.Optimaxx.OptimaxxBackend.config;

import dk.Optimaxx.OptimaxxBackend.entity.*;
import dk.Optimaxx.OptimaxxBackend.repository.*;
import dk.Optimaxx.OptimaxxBackend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Configuration
@Profile({"development"})
@RequiredArgsConstructor
public class DummyDataConfig implements ApplicationRunner {
    private final MovieRepository movieRepository;
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final ShowingRepository showingRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountRepository.deleteAll();
        accountRepository.saveAll(makeAccountData());

        movieRepository.deleteAll();
        movieRepository.saveAll(makeMovieData());

        cinemaRepository.deleteAll();
        cinemaRepository.saveAll(makeCinemaData());

        roomRepository.deleteAll();
        roomRepository.saveAll(makeRoomData());

        seatRepository.deleteAll();
        seatRepository.saveAll(makeSeatData());

        showingRepository.deleteAll();
        showingRepository.saveAll(makeShowingData());

        reservationRepository.deleteAll();
        reservationRepository.saveAll(makeReservationData());
    }

    private List<Account> makeAccountData() {
        return List.of(
                Account.builder()
                        .email("jane.doe@mail.com")
                        .name("Jane Doe")
                        .phoneNumber("12345678")
                        .build(),
                Account.builder()
                        .email("john.smith@mail.com")
                        .name("John Smith")
                        .phoneNumber("87654321")
                        .build()
        );
    }

    private List<Movie> makeMovieData() {
        return List.of(Movie.builder()
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
    }

    private List<Cinema> makeCinemaData() {
        return List.of(
                Cinema.builder()
                        .name("CineMark")
                        .location("Mark's Baghave")
                        .build(),
                Cinema.builder()
                        .name("BioTrio")
                        .location("Mark's Nabo's Baghave")
                        .build()
        );
    }

    private List<Room> makeRoomData() {
        List<Room> temporaryRooms = new ArrayList<>();
        for (Cinema cinema : cinemaRepository.findAll()) {
            temporaryRooms.add(
                    Room.builder()
                            .cinema(cinema)
                            .description("Sal #1")
                            .build()
            );
            temporaryRooms.add(
                    Room.builder()
                            .cinema(cinema)
                            .description("Sal #2")
                            .build()
            );
            temporaryRooms.add(
                    Room.builder()
                            .cinema(cinema)
                            .description("Sal #3")
                            .build()
            );
        }
        return temporaryRooms;
    }

    private List<Seat> makeSeatData() {
        List<Seat> temporarySeats = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            for (int i : IntStream.rangeClosed(1, 18).toArray()) { // seat numbers goes along the screen
                for (int j : IntStream.rangeClosed(1, 7).toArray()) { // row numbers goes away from the screen
                    temporarySeats.add(Seat.builder()
                            .room(room)
                            .type("standard")
                            .seatNumber(i)
                            .seatRow(j)
                            .build()
                    );
                }
            }
        }
        return temporarySeats;
    }

    private List<Showing> makeShowingData() {
        List<LocalDateTime> times = List.of(
                LocalDateTime.now().plusDays(2L).withHour(19).withMinute(0).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(2L).withHour(19).withMinute(30).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(3L).withHour(19).withMinute(0).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(3L).withHour(19).withMinute(30).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(4L).withHour(19).withMinute(0).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(4L).withHour(19).withMinute(30).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(5L).withHour(19).withMinute(0).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(5L).withHour(19).withMinute(30).withSecond(0).withNano(0)
        );

        List<Showing> temporaryShowings = new ArrayList<>();

        for (Room room : roomRepository.findAll()) {
            for (LocalDateTime time : times) {
                int randomMovieIndex = (int) (ThreadLocalRandom.current().nextInt(movieRepository.findAll().size()) % movieRepository.count());
                temporaryShowings.add(
                        Showing.builder()
                                .movie(movieRepository.findAll().get(randomMovieIndex))
                                .startTime(time)
                                .room(room)
                                .basePrice(69)
                                .build()
                );
            }
        }
        return temporaryShowings;
    }

    private List<Reservation> makeReservationData() {
        return List.of();
    }
}
