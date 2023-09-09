package generator.mapper;

import generator.domain.Book;

/**
* @author Administrator
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-09-08 12:57:59
* @Entity generator.domain.Book
*/
public interface BookMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

}
