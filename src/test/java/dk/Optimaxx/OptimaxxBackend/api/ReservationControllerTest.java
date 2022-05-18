package dk.Optimaxx.OptimaxxBackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.entity.*;
import dk.Optimaxx.OptimaxxBackend.repository.*;
import lombok.NoArgsConstructor;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@NoArgsConstructor
@Transactional
class ReservationControllerTest {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void setup(@Autowired ReservationRepository reservationRepository,
                             @Autowired AccountRepository accountRepository,
                             @Autowired MovieRepository movieRepository,
                             @Autowired CinemaRepository cinemaRepository,
                             @Autowired RoomRepository roomRepository,
                             @Autowired SeatRepository seatRepository,
                             @Autowired ShowingRepository showingRepository){

        Account account1;
        Account account2;
        List<Seat> temporarySeats = new ArrayList<>();
        List<Room> temporaryRooms = new ArrayList<>();
        List<Showing> temporaryShowings = new ArrayList<>();

        accountRepository.saveAll(List.of(
                account1 = Account.builder()
                        .email("jane.doe@mail.com")
                        .name("Jane Doe")
                        .phoneNumber("12345678")
                        .build(),
                account2 = Account.builder()
                        .email("john.smith@mail.com")
                        .name("John Smith")
                        .phoneNumber("87654321")
                        .build()
        ));

        movieRepository.saveAll(List.of(Movie.builder()
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
        ));

        cinemaRepository.saveAll(List.of(
                Cinema.builder()
                        .name("CineMark")
                        .location("Mark's Baghave")
                        .build(),
                Cinema.builder()
                        .name("BioTrio")
                        .location("Mark's Nabo's Baghave")
                        .build()
        ));


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
            roomRepository.saveAll(temporaryRooms);


            for (Room room : roomRepository.findAll()) {
                for (int i : IntStream.rangeClosed(1, 24).toArray()) { // seat numbers goes along the screen
                    for (int j : IntStream.rangeClosed(1, 15).toArray()) { // row numbers goes away from the screen
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
            seatRepository.saveAll(temporarySeats);

            List<LocalDateTime> times = List.of(
                    LocalDateTime.now().plusDays(2L).withHour(17).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(17).withMinute(30).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(18).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(18).withMinute(30).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(19).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(19).withMinute(30).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(20).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2L).withHour(20).withMinute(30).withSecond(0).withNano(0)
            );



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
        showingRepository.saveAll(temporaryShowings);


        reservationRepository.saveAll(List.of(Reservation.builder()
                        .seats(Set.of(temporarySeats.get(0),temporarySeats.get(1)))
                        .account(account1)
                        .showing(temporaryShowings.get(3))
                .build()));

        reservationRepository.saveAll(List.of(Reservation.builder()
                .seats(Set.of(temporarySeats.get(3),temporarySeats.get(4),temporarySeats.get(5),temporarySeats.get(6)))
                .account(account1)
                .showing(temporaryShowings.get(3))
                .build()));


    }

    @AfterAll
    public static void tearDown(@Autowired ReservationRepository reservationRepository,
                                @Autowired AccountRepository accountRepository,
                                @Autowired MovieRepository movieRepository,
                                @Autowired CinemaRepository cinemaRepository,
                                @Autowired RoomRepository roomRepository,
                                @Autowired SeatRepository seatRepository,
                                @Autowired ShowingRepository showingRepository) {
        reservationRepository.deleteAll();
        accountRepository.deleteAll();
        movieRepository.deleteAll();
        cinemaRepository.deleteAll();
        roomRepository.deleteAll();
        seatRepository.deleteAll();
        showingRepository.deleteAll();
    }

    @Test
    void getMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/reservations")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
        ;
    }

    @Test
    void getReservations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/reservations/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        ;
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/reservations/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        ;
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/reservations/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
        ;
    }

    @Test
    void addReservation() throws Exception {

        //TODO: add this code back when the infinite recursion reservation creation has been finished.

        /*
        Account accountGet = accountRepository.findAll().get(0);
        Set<Seat> seatsGet = Set.of(seatRepository.getById(1L));
        Showing showingGet = showingRepository.getById(1L);


        Reservation randomRes = Reservation.builder()
                .account(accountGet)
                .seats(seatsGet)
                .showing(showingGet)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomRes);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/reservations")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isNotAcceptable());

         */
    }
}