package com.kassa.mybatis;

import com.kassa.dto.ProductDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
}
