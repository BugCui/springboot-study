package com.coinker.tdengine.controller;

import cn.hutool.core.date.DateUtil;
import com.coinker.tdengine.domain.AIpos;
import com.coinker.tdengine.service.AIposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cui Shenpeng
 * @Classname AIposController
 * @Date 2021/9/22 16:08
 */
@RestController
@RequestMapping("/aipos")
public class AIposController {

    @Autowired
    private AIposService aIposService;

    @GetMapping("/init")
    public boolean init() {
        return aIposService.init();
    }

    @GetMapping("insert")
    public boolean insert() {
        AIpos aIpos = AIpos.builder().productKey("g7ajakeusts").iotId("123456789").deviceName("ABCDEFG")
                .time_stamp(DateUtil.date().toJdkDate())
                .uptime(22.0)
                .cpu_used_pp(33.0)
                .mem_used(44.0).build();
        return this.aIposService.insert(aIpos);
    }

    @GetMapping("query")
    public List<Double> query(@RequestParam String identifier) {
        return this.aIposService.query("ABCDEFG", identifier);
    }

}
