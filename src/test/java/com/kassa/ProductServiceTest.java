package com.kassa;

import com.kassa.entity.Check;
import com.kassa.entity.Product;
import com.kassa.service.ProductListWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;

import java.math.BigDecimal;
import java.time.LocalDate;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ProductServiceTest {
    Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${local.server.port}")
    int port;

    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1");

    static {
        postgreSQLContainer.start();
        System.setProperty("DB_URL", postgreSQLContainer.getJdbcUrl());
        System.setProperty("DB_USER", postgreSQLContainer.getUsername());
        System.setProperty("DB_PASSWORD", postgreSQLContainer.getPassword());
    }

    @Test
    public void addNewAndGetProductTest() {

        Product product = new Product(
                null,
                "Potato",
                23,
                300,
                new BigDecimal(300),
                1L, "forBorsh");

        String url = "http://localhost:" + port;

        ResponseEntity<Product> productResponseEntity = restTemplate.postForEntity(url + "/product", new HttpEntity<>(product), Product.class);
        Assertions.assertEquals(productResponseEntity.getStatusCode(), HttpStatus.OK);

        ResponseEntity<ProductListWrapper> forEntity = restTemplate.getForEntity(url + "/products/" + product.getProductName(), ProductListWrapper.class);
        Assertions.assertEquals(forEntity.getStatusCode(), HttpStatus.OK);

        ProductListWrapper body = forEntity.getBody();
        Product product1 = body.getProductList().get(0);
        Assertions.assertEquals(product.getComment(), product1.getComment());
    }

    @Test
    public void addNewAndGetCheckTest() {

        Check check = new Check(
                null,
                500.0,
                LocalDate.now(),
                "Gucci",
                "tapki");

        String url = "http://localhost:" + port;

        ResponseEntity<Check> productResponseEntity = restTemplate.postForEntity(url + "/check", new HttpEntity<>(check), Check.class);
        Assertions.assertEquals(productResponseEntity.getStatusCode(), HttpStatus.OK);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url + "/checks/" + check.getDate(), String.class);
        Assertions.assertEquals(HttpStatus.OK, forEntity.getStatusCode());
    }
}
