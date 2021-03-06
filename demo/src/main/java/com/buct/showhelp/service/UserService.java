package com.buct.showhelp.service;

import com.buct.showhelp.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    Users userLogin(String userNumber, String password);

    int userRegister(Users users);

    //更新个人信息
    int updateUser(Users users);

    int changePassword(int id, String psw);

    Users findUserById(int id);

    List<Users> findUserByName(String keyword);

    Users findUserByEmail(String email);

    List<Users> findAllUser();
}