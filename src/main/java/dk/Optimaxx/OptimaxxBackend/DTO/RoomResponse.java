package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String description;

    public RoomResponse(Long id, String description) {
        this.id = id;
        this.description = description;
    }


}
