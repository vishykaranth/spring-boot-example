package product;

import controller.Product;

import java.util.Collection;

public class ProductRepositoryInDatabase implements ProductRepository {

    ProductDatabaseObject productDatabaseObject;

    public ProductRepositoryInDatabase() {
        productDatabaseObject = new ProductDatabaseObject();
    }

    @Override
    public Collection<Product> getProducts() {
        return productDatabaseObject.getProducts();
    }

    @Override
    public void createProduct(Product product) {
        productDatabaseObject.createProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productDatabaseObject.deleteProduct(id);
    }

    @Override
    public void updateProduct(String id, Product product) {
        productDatabaseObject.updateProduct(id, product);
    }
}
