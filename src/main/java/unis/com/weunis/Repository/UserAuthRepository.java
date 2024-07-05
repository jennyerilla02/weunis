package unis.com.weunis.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}