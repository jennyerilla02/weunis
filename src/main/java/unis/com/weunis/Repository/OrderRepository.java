package unis.com.weunis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}