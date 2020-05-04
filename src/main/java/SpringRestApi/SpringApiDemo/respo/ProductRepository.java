package SpringRestApi.SpringApiDemo.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringRestApi.SpringApiDemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
