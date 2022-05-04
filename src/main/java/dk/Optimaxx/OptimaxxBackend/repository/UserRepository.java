package dk.Optimaxx.OptimaxxBackend.repository;

import dk.Optimaxx.OptimaxxBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
