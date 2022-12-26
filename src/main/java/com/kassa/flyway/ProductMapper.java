package com.kassa.flyway;

import com.kassa.dto.ProductDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO kassa.product " +
            "(\"PRODUCT_NAME\", \"AMOUNT\", \"ACCOUNT\", \"WEIGHT\", \"CHECK_ID\", \"DESCRIPTION\") VALUES " +
            "(#{productName}, #{amount}, #{account}, #{weight}, #{checkId}, #{description});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "PRODUCT_ID")
    Integer addProduct(ProductDTO productDTO);

    @Select("SELECT \n" +
            "  \"PRODUCT_NAME\" as productName, \n" +
            "  \"AMOUNT\" as amount, \n" +
            "  \"ACCOUNT\" as account, \n" +
            "  \"WEIGHT\" as weight,  \n" +
            "  \"CHECK_ID\" as checkId, \n" +
            "  \"PRODUCT_ID\" as id, \n" +
            "  \"DESCRIPTION\" as description  \n" +
            " FROM kassa.product  ")
    List<ProductDTO> getAllProducts();

    @Select("SELECT \n" +
            "  \"PRODUCT_NAME\" as productName, \n" +
            "  \"AMOUNT\" as amount, \n" +
            "  \"ACCOUNT\" as account, \n" +
            "  \"WEIGHT\" as weight,  \n" +
            "  \"CHECK_ID\" as checkId, \n" +
            "  \"PRODUCT_ID\" as id, \n" +
            "  \"DESCRIPTION\" as description  \n" +
            " FROM kassa.product WHERE \"PRODUCT_NAME\" = #{productName} ")
    List<ProductDTO> getProductsByName(String productName);

    @Select("SELECT \n" +
            "  \"PRODUCT_NAME\" as productName, \n" +
            "  \"AMOUNT\" as amount, \n" +
            "  \"ACCOUNT\" as account, \n" +
            "  \"WEIGHT\" as weight,  \n" +
            "  \"CHECK_ID\" as checkId, \n" +
            "  \"PRODUCT_ID\" as id, \n" +
            "  \"DESCRIPTION\" as description  \n" +
            " FROM kassa.product WHERE \"CHECK_ID\" = #{checkId} ")
    List<ProductDTO> getProductsByCheckId(Long checkId);

    @Select("SELECT \n" +
            "  \"PRODUCT_NAME\" as productName, \n" +
            "  \"AMOUNT\" as amount, \n" +
            "  \"ACCOUNT\" as account, \n" +
            "  \"WEIGHT\" as weight,  \n" +
            "  \"CHECK_ID\" as checkId, \n" +
            "  \"PRODUCT_ID\" as id, \n" +
            "  \"DESCRIPTION\" as description  \n" +
            " FROM kassa.product WHERE \"PRODUCT_ID\" = #{id} ")
    ProductDTO getProductById(Long id);

    @Delete("DELETE FROM kassa.product WHERE \"PRODUCT_ID\" = #{id}")
    int deleteProduct(Long id);
}
