package unis.com.weunis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
