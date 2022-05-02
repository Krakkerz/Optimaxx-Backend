package dk.Optimaxx.OptimaxxBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    private Long id;
    private String name;
    private String description;
    private String category;
    private int ageRange;
    private Duration duration;
    private double rating;
    private String picture;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}


