package dk.Optimaxx.OptimaxxBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @OneToMany(mappedBy = "room", fetch =FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Seat> seats = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "room", fetch =FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Showing> showings = new java.util.LinkedHashSet<>();

    private String description;

}


