package com.kassa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
//@Testcontainers
public class ProductServiceTest {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${local.server.port}")
    int port;

    //    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1");
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");

    //    @BeforeAll
//    static void beforeAll() {
    static {
        postgreSQLContainer.start();
        System.setProperty("DB_URL", postgreSQLContainer.getJdbcUrl());
        System.setProperty("DB_USER", postgreSQLContainer.getUsername());
        System.setProperty("DB_PASSWORD", postgreSQLContainer.getPassword());
    }

    @Test
    public void addNewProductTest() {
        int a = 9;
//        restTemplate.exchange();
//        ResponseEntity<Foo> response =
//                restTemplate.exchange(url, HttpMethod.GET, request, Foo.class);
//
//        ResponseEntity<Foo> response =
//                restTemplate.getForEntity(url, Foo.class);
//        Product product = new Product(
//                null,
//                "Potato",
//                23,
//                300,
//                new BigDecimal(300),
//                1L, "forBorsh");
//
//        service.addNewProduct(product);
//        Product potato = service.getProductsByName("Potato").get(0);
//
//        Assertions.assertEquals(product.getProductName(), potato.getProductName());
    }
}
