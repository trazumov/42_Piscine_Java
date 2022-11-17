package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
    private DataSource ds;

    public ProductsRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }
    
    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";

        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            products.add(new Product(
                    resultSet.getLong("identifier"),
                    resultSet.getString("name"),
                    resultSet.getInt("price")));
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Optional<Product> product;
        String query = "SELECT * FROM product WHERE identifier = " + id;

       Connection connection = ds.getConnection();
       Statement statement = connection.createStatement();

       ResultSet resultSet = statement.executeQuery(query);
       if (!resultSet.next()) {
           throw new SQLException();
       }
       return Optional.of(new Product(
               resultSet.getLong("identifier"),
               resultSet.getString("name"),
               resultSet.getInt("price")));
    }

    @Override
    public void update(Product product) throws SQLException {
        String query = "UPDATE product SET name = ?, price = ?  WHERE identifier = ?;";

        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setLong(3, product.getId());

        statement.execute();
    }


    @Override
    public void save(Product product) throws SQLException {
        String query = "INSERT INTO product (identifier, name, price) VALUES (?, ?, ?);";

        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setInt(3, product.getPrice());

        statement.execute();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String query = "DELETE FROM product WHERE identifier = " + id + ";";

        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
        connection.close();
    }
}
