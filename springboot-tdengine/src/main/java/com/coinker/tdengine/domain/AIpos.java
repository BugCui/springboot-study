package com.coinker.tdengine.domain;

import lombok.*;

import java.util.Date;

/**
 * @author Cui Shenpeng
 * @Classname AIpos
 * @Date 2021/9/22 16:09
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AIpos {

    private String productKey;

    private String deviceName;

    private String iotId;

    private Date time_stamp;

    private Double uptime;

    private Double mem_used;

    private Double cpu_used_pp;

}
