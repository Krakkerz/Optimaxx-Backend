package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;


@Data
public class ShowingResponse {
    private Long id;
    private MovieResponse movie;
    private RoomResponse room;

    private LocalDateTime startDateTime;
    private LocalDate startDate;
    private LocalTime startTime;
    private String startWeekday;

    private Integer basePrice;

    private ShowingResponse(Showing showing) {
        this.id = showing.getId();
        this.movie = showing.getMovie() == null ? null : MovieResponse.of(showing.getMovie());
        this.room = showing.getRoom() == null ? null : RoomResponse.of(showing.getRoom());

        List<Long> reservedSeatIds = showing.getReservations().stream()
                .map(Reservation::getSeats)
                .flatMap(Collection::stream)
                .map(Seat::getId).toList();

        this.room.getSeats().forEach(seat -> seat.setReserved(reservedSeatIds.contains(seat.getId())));

        this.startDateTime = showing.getStartTime();
        this.startDate = showing.getStartTime().toLocalDate();
        this.startTime = showing.getStartTime().toLocalTime();
        this.startWeekday = showing.getStartTime().getDayOfWeek().toString();

        this.basePrice = showing.getBasePrice();
    }

    public static ShowingResponse of(Showing entity) {
        return new ShowingResponse(entity);
    }

    public static List<ShowingResponse> of(Collection<Showing> entities) {
        return entities.stream().map(ShowingResponse::new).toList();
    }
}
