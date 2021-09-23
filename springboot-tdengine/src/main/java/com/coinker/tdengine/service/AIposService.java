package com.coinker.tdengine.service;

import com.coinker.tdengine.dao.AIposMapper;
import com.coinker.tdengine.domain.AIpos;
import com.coinker.tdengine.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Cui Shenpeng
 * @Classname AIposService
 * @Date 2021/9/22 16:09
 */
@Service
public class AIposService {

    @Autowired
    private AIposMapper aIposMapper;

    public boolean init() {
        try {
//            aIposMapper.dropDB();
//            aIposMapper.createDB();
            aIposMapper.createSuperTable();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert(AIpos aIpos) {
        aIposMapper.insert(aIpos);
        return true;
    }

    public List<Double> query(String deviceName, String identifier) {
        return this.aIposMapper.query(deviceName, identifier);
    }
}
