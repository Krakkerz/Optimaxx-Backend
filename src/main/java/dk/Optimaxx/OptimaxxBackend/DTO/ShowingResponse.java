package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.entity.Room;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import dk.Optimaxx.OptimaxxBackend.utilities.DurationFormatter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
public class ShowingResponse {
    private Long id;
    private RoomResponse room;
    private String startTime;
    private Integer basePrice;

    private ShowingResponse(Showing showing) {
        this.id = showing.getId();
        this.room = showing.getRoom() == null ? null : RoomResponse.of(showing.getRoom());
        this.startTime = DurationFormatter.formatLocalDateTime(showing.getStartTime());
        this.basePrice = showing.getBasePrice();
    }

    public static ShowingResponse of(Showing entity) {
        return new ShowingResponse(entity);
    }

    public static List<ShowingResponse> of(Collection<Showing> entities) {
        return entities.stream().map(ShowingResponse::new).toList();
    }
}
