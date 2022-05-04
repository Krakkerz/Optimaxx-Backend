package dk.Optimaxx.OptimaxxBackend.repository;

import dk.Optimaxx.OptimaxxBackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, String> {
}
