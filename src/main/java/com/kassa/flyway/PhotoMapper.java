package com.kassa.flyway;

import com.kassa.entity.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhotoMapper {

    @Insert("insert into kassa.photos " +
            "(\"FILE_ID\", \"MESSAGE_DATE\", \"ADDED_DATE\",\"PROCESSED\", \"PATH\" ) values " +
            "(#{fileId}, #{messageDate}, #{addedDate}, #{processed}, #{path} );")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    Long addPhoto(Photo photo);

    @Select("SELECT \n" +
            "  \"ID\" as id, \n" +
            "  \"FILE_ID\" as fileId, \n" +
            "  \"MESSAGE_DATE\" as messageDate, \n" +
            "  \"ADDED_DATE\" as addedDate, \n" +
            "  \"PROCESSED\" as processed, \n" +
            "  \"PATH\" as path \n" +
            " FROM kassa.photos  ")
    List<Photo> getNotProcessedPhotos();
}
