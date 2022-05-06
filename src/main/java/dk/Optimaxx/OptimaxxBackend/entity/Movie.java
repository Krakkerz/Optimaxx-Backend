package dk.Optimaxx.OptimaxxBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    private String id;
    private String title;
    private String category;
    private Integer minimumAge;
    private Duration duration;
    private LocalDate releaseDate;
    private Double rating;
    private String picture;
    private String trailer;
    private String tagline;
    @Lob
    private String plot;

    @OneToMany(mappedBy = "movie", fetch =FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Showing> showings = new java.util.LinkedHashSet<>();
}


