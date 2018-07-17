package com.cosis.crm.cash.mapper;

import com.cosis.crm.cash.domain.entity.IncomeInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface IncomeInfoMapper {

    public static final String TABLE = "income_info";

    public static final String ALL_COLUMN_FIELDS = "income_type, principal,rate,profit,begin_date,value_date,end_date,day_nums, create_time,user_id";

    public static final String SELECT_COLUMN_FIELDS = "id,income_type, principal,rate,profit,begin_date,value_date,end_date,day_nums, create_time,user_id";

    @Select("select " + SELECT_COLUMN_FIELDS +" from " + TABLE)
    List<IncomeInfo> getAll();

    @Insert("INSERT INTO " + TABLE + " (" + ALL_COLUMN_FIELDS + " ) " +
            " values(" +
            " #{income_type}, #{principal}, #{rate}, #{profit}, #{begin_date}, #{value_date}, #{end_date}, #{day_nums}, #{create_time},#{user_id}" +
            " ) ")
    int add(IncomeInfo type);

    @Delete("delete from   " + TABLE + " where id = #{id}")
    int del(@Param("id")int id);


}
