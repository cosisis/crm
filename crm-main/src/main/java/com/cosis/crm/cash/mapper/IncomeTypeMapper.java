package com.cosis.crm.cash.mapper;

import com.cosis.crm.cash.domain.entity.IncomeType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface IncomeTypeMapper {

    public static final String TABLE = "income_type";

    public static final String ALL_COLUMN_FIELDS = "type_name";

    public static final String SELECT_COLUMN_FIELDS = "id, type_name";

    @Select("select " + SELECT_COLUMN_FIELDS +" from " + TABLE)
    List<IncomeType> getAll();

    @Insert("INSERT INTO " + TABLE + " (" + ALL_COLUMN_FIELDS + " ) " +
            " values(" +
            " #{type_name}" +
            " ) ")
    int add(IncomeType type);

    @Delete("delete from " + TABLE + " where id = #{id}")
    int del(@Param("id") int id);

    @Update("UPDATE " + TABLE + " SET type_name=#{type_name} WHERE id=#{id}")
    int update(IncomeType type);

    /**
     * 根据名称查找用户
     */
    @Select("SELECT * " + " FROM " + TABLE + " WHERE type_name=#{type_name}")
    IncomeType getIncomeTypeByType_name(@Param("type_name") String type_name);

}
