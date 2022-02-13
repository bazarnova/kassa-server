package com.kassa.mybatis;

import com.kassa.dto.CheckDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CheckMapper {

    @Insert("INSERT INTO kassa.checks " +
            "(\"SUM_AMOUNT\", \"DATE\", \"SHOP_NAME\", \"COMMENT\") VALUES " +
            "(#{sumAmount}, #{date}, #{shopName}, #{comment});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    Long addCheck(CheckDTO checkDTO);

    @Select("SELECT \n" +
            "  \"ID\" as id, \n" +
            "  \"SUM_AMOUNT\" as sumAmount, \n" +
            "  \"DATE\" as date, \n" +
            "  \"SHOP_NAME\" as shopName, \n" +
            "  \"COMMENT\" as comment \n" +
            " FROM kassa.checks")
    List<CheckDTO> getAllChecks();
}
