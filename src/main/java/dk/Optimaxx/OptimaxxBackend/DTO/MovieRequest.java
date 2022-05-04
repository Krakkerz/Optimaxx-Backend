package dk.Optimaxx.OptimaxxBackend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MovieRequest {
    private String id;
    private String text;
}
