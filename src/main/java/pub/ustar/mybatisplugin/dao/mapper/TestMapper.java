package pub.ustar.mybatisplugin.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pub.ustar.mybatisplugin.dao.bean.Test;

@Mapper
public interface TestMapper {

    @Select("select * from test where id = #{id}")
    public Test selectById(int id);

    @Insert("insert into test (id, version) values (#{id}, #{version})")
    public int insert(@Param("id") int id, @Param("version") int version);
}
