package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Room;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Data
public class RoomResponse {
    private Long id;
    private String description;
    private List<SeatResponse> seats;

    public RoomResponse(Room room) {
        this.id = room.getId();
        this.description = room.getDescription();

        this.seats = room.getSeats() == null ? null : SeatResponse.of(room.getSeats());
    }

    public static List<RoomResponse> of(Collection<Room> entities) {
        return entities.stream().map(RoomResponse::new).toList();
    }

    public static RoomResponse of(Room entity) {
        return new RoomResponse(entity);
    }
}
