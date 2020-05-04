package SpringRestApi.SpringApiDemo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringRestApi.SpringApiDemo.model.Product;
import SpringRestApi.SpringApiDemo.service.ProductService;
import jdk.internal.jline.internal.Log;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> list() {

		return productService.listAll();

	}

	@RequestMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = productService.get(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		productService.save(product);
	}
   @PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id)
	{
	   try {
	   Product exitProduct= productService.get(id);
		productService.save(product);
		
		return new ResponseEntity<>(HttpStatus.OK);
	   } catch(Exception e)
	   {
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	}
   @DeleteMapping("/products/{id}")
   public void delete(@PathVariable Integer id)
   {
	  productService.delete(id);
	  Log.info("Delete Sucessfully Record");
   }

}
