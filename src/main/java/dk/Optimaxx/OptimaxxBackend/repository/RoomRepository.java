package dk.Optimaxx.OptimaxxBackend.repository;

import dk.Optimaxx.OptimaxxBackend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
