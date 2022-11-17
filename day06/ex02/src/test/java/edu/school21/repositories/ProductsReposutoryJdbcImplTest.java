package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class ProductsReposutoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "apple", 5),
            new Product(2L, "milk", 10),
            new Product(3L, "juice", 13),
            new Product(4L, "pizza", 20),
            new Product(5L, "salad", 15));

    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4L, "pizza", 20);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(1L, "tomato", 3);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "cucumber", 2);

    ProductsRepository productsRepository;
    EmbeddedDatabase dataSource;

    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(4L).get());
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepository.findById(1L).get());
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, productsRepository.findById(6L).get());
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(SQLException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
