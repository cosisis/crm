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

    public static final String SELECT_COLUMN_FIELDS = " type_name";

    @Select("select " + SELECT_COLUMN_FIELDS +" from " + TABLE)
    List<IncomeType> getAll();

    @Insert("INSERT INTO " + TABLE + " (" + ALL_COLUMN_FIELDS + " ) " +
            " values(" +
            " #{type_name}" +
            " ) ")
    int add(IncomeType type);

    @Delete("delete from " + TABLE + " where id = #{id}")
    int del(@Param("id")int id);

}
