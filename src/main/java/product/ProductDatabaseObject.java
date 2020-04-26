package product;

import controller.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabaseObject {
    Connection connection;
    Statement statement;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ProductDatabaseObject(){
        DatabaseUtil databaseUtil = new DatabaseUtil();
        connection = databaseUtil.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ProductDatabaseObject productDatabaseObject = new ProductDatabaseObject();
        List<Product> products = productDatabaseObject.getProducts();
        System.out.println(products);
    }

    public void createProduct(Product product) {
        try {
            String sql = "INSERT INTO PRODUCT (ID,NAME) "
                    + "VALUES ('" + product.getId()
                    + "', '" + product.getName() + "');";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PRODUCT;");
            Product product;
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                product = new Product(id, name);
                productList.add(product);
            }
            rs.close();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return productList;
    }

    public void deleteProduct(String id) {
        try {
            String sql = "DELETE from PRODUCT where ID = '" + id + "';";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateProduct(String id, Product product) {
        try {
            String sql = "UPDATE PRODUCT set NAME = '" + product.getName() + "' where ID = '" + id + "';";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
