package com.cosis.crm.cash.service.impl;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.mapper.IncomeTypeMapper;
import com.cosis.crm.cash.service.IncomeTypeService;
import com.cosis.crm.cash.utils.CheckHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 理财类型
 * @author lz
 */
@Slf4j
@Service
public class IncomeTypeServiceImpl implements IncomeTypeService{

    @Autowired
    CheckHelper checkHelper;

    @Autowired
    IncomeTypeMapper typeMapper;

    /**
     * 保存 理财类型
     * @param incomeType
     * @return
     */
    public Result save (IncomeType incomeType){
        log.info(" IncomeTypeServiceImpl save id {},type_name ",incomeType.getId(),incomeType.getType_name());


        IncomeType type =  typeMapper.getIncomeTypeByType_name(incomeType.getType_name());
        if (type != null) {
            Result result = new Result();
            result.setRetEnum(RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_SAVE) ;
            return result;
        }
        if (incomeType.getId()==0){
            return add(incomeType);
        }else {

            return update(incomeType);
        }
    }

    /**
     * 添加 理财类型
     * @param incomeType
     * @return
     */
    public Result add (IncomeType incomeType){
        Result result = new Result();
        result.setRetEnum((typeMapper.add(incomeType) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_ADD) ;
        return result;
    }

    /**
     * 删除 理财类型
     * @param incomeType
     * @return
     */
    public Result del (IncomeType incomeType){
        Result result = new Result();
        result.setRetEnum((typeMapper.del(incomeType.getId()) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_DEL) ;
        return result;
    }

    /**
     * 修改 理财类型
     * @param incomeType
     * @return
     */
    public Result update (IncomeType incomeType){
        Result result = new Result();
        result.setRetEnum((typeMapper.update(incomeType) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_UPDATE) ;
        return result;
    }

    /**
     * 查询已有的理财类型列表
     * @return
     */
    public List<IncomeType> query(){
        log.info(" service query()");
        return typeMapper.getAll();
    }
}
