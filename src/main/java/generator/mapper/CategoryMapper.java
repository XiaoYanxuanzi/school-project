package generator.mapper;

import generator.domain.Category;

/**
* @author Administrator
* @description 针对表【category】的数据库操作Mapper
* @createDate 2023-09-07 19:52:59
* @Entity generator.domain.Category
*/
public interface CategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

}
