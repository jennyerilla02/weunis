package unis.com.weunis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}