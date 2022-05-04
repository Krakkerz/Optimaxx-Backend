package dk.Optimaxx.OptimaxxBackend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomRequest {
    private Long id;
    private String description;
}
