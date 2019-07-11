package com.paymoon.demo.vo.dao;

import com.paymoon.demo.vo.TSpmcProcessStockChange;

public interface TSpmcProcessStockChangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TSpmcProcessStockChange record);

    int insertSelective(TSpmcProcessStockChange record);

    TSpmcProcessStockChange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TSpmcProcessStockChange record);

    int updateByPrimaryKey(TSpmcProcessStockChange record);
}