package com.coinker.tdengine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Cui Shenpeng
 * @Classname AIpos
 * @Date 2021/9/22 16:09
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AIpos {

    private String productKey;

    private String deviceName;

    private String iotId;

    private Double uptime;

    private Double mem_used;

    private Double cpu_used_pp;

}
