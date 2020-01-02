package com.buct.showhelp.mapper;

import com.buct.showhelp.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //登录注册
    @Select("select * from users where email = #{email} and password = #{password}")
    Users userLogin(@Param("email") String email, @Param("password") String password);

//    name number password tel address email school ip picturePath
    @Insert("insert into users (name, password, number, tel, address, email, school, ip, picture_path) values(#{name}, #{password}, '', '', '', '', '', '', '' )")
    int userRegister(@Param("name") String name, @Param("password") String password);

    //CURD
}
