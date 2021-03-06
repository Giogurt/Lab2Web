/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.manager.ProductManager;

/**
 * productController class
 * 
 * @author giogurt
 */
@RestController
public class ProductController {

	@Resource
	private ProductManager productManager;

	/**
	 * The end point for GET {url}/products
	 * @return status 200 if there are products
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	/**
	 * * The end point for GET {url}/products?search={pattern} 
	 * @param search Pattern to search 
	 * @return a json list of all the products matching the pattern
	 */
	@GetMapping(value = "/products", params = "search")
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	/**
	 * The end point for GET {url}/products/{id}
	 * @param id id of the document to retrieve
	 * @return status 200 if the product id is found or 204 if is not found
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		Optional<Product> product = productManager.getProduct(id);

		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}

		return responseEntity;
	}

	/**
	 * The end point for POST {url}/products/ 
	 * @param newProduct a json containing the info for the new product 
	 * @return If the product is created successfully then status 201 and the product info is returned, otherwise it returns status 400
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		Product product = productManager.addProduct(newProduct);
		return  new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	/**
	 * The end point for PUT {url}/products/{id}
	 * @param id id of the product to update
	 * @param modifiedProduct updated product
	 * @return status 201 if the product is found and the new product content is correct or 400 if the data is not correct
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id,
			@RequestBody Product modifiedProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		if (product.isPresent()) {
			productManager.updateProduct(id, modifiedProduct);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}

	/**
	 * The end point for DELETE {url}/products/{id}
	 * @param id id of product to delete
	 * @return status 200 if the product is found or 204 if the product is not found
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		if (product.isPresent()) {
			productManager.deleteProduct(product.get());
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}

}
