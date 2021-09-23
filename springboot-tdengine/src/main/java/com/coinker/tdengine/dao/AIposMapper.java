package com.coinker.tdengine.dao;

import com.coinker.tdengine.domain.AIpos;

import java.util.List;

/**
 * @author Cui Shenpeng
 * @Classname AIposMapper
 * @Date 2021/9/22 16:14
 */
public interface AIposMapper {

    void dropDB();

    void createDB();

    void createSuperTable();

    void insert(AIpos aIpos);

    List<Double> query(String deviceName, String identifier);
}


