package com.nttdata.app.api.response;

import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BootcoinsResponse {
    private String id;
    private String typeOprations;
    private int minimumCoins;
    private int maximumCoins;
    private BigDecimal cost;
}
