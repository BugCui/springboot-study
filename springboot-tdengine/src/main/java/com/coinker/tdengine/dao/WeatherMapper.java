package com.coinker.tdengine.dao;

import com.coinker.tdengine.domain.Weather;

import java.util.List;

public interface WeatherMapper {

    void dropDB();

    void createDB();

    void createSuperTable();

    void createTable(Weather weather);

    List<Weather> select(Long limit, Long offset);

    int insert(Weather weather);

    int count();

    List<String> getSubTables();

    List<Weather> avg();

}
