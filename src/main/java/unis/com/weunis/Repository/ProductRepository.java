package unis.com.weunis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unis.com.weunis.Model.Product;

public interface ProductRepository extends JpaRepository<Product ,Long>{

}
