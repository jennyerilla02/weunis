package unis.com.weunis.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
