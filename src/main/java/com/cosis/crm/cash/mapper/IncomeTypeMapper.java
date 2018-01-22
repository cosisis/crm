package com.cosis.crm.cash.mapper;

import com.cosis.crm.cash.domain.entity.IncomeType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IncomeTypeMapper {

    public static final String TABLE = "income_type";

    public static final String ALL_COLUMN_FIELDS = "type_name, create_name, create_time";

    public static final String SELECT_COLUMN_FIELDS = "type_id, type_name";

    @Select("select " + SELECT_COLUMN_FIELDS +" from " + TABLE)
    List<IncomeType> getAll();

    @Insert("inset into " + TABLE + " (" + ALL_COLUMN_FIELDS + " ) " +
            " values(" +
            " #{type_name}, #{create_name}, #{create_time} " +
            " ) ")
    int add(IncomeType type);

    @Delete("delete from " + TABLE + " where id = #{id}")
    int del(@Param("id")int typeid);

}
