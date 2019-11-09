package com.cosis.crm.cash.mapper;

import com.cosis.crm.cash.domain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface UserMapper {
    public static final String TABLE = "user";

    public static final String ALL_COLUMN_FIELDS = "ID, USERCODE, PASSWORD, username";

    public static final String SELECT_COLUMN_FIELDS = "USERCODE, PASSWORD, USERNAME";


    /**
     * 根据名称查找用户
     */
    @Select("SELECT * " + " FROM " + TABLE + " WHERE usercode=#{usercode} AND    password=#{PASSWORD} ")
    UserInfo getUser_name_password(@Param("usercode") String usercode, @Param("PASSWORD") String PASSWORD);
}
