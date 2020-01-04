package product;

import controller.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> getProducts();
    void createProduct(Product product);
    void deleteProduct(String id);
    void updateProduct(String id, Product product);
}
