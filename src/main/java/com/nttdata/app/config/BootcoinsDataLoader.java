package com.nttdata.app.config;

import com.nttdata.app.documents.BootcoinsRate;
import com.nttdata.app.service.BootcoinsService;
import com.nttdata.app.utils.StatusRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class BootcoinsDataLoader implements ApplicationRunner {
    @Autowired
    private BootcoinsService bcs;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (bcs.count().block().equals(0L))
        {
            BootcoinsRate bcr1=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("compra de bootcoins")
                    .typeOprations(StatusRate.PURCHASE)
                    .minimumCoins(0)
                    .maximumCoins(100)
                    .cost(BigDecimal.valueOf(3.00))
                    .status("1")
                    .build();
            BootcoinsRate bcr2=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("venta de bootcoins")
                    .typeOprations(StatusRate.SALE)
                    .minimumCoins(0)
                    .maximumCoins(100)
                    .cost(BigDecimal.valueOf(6.00))
                    .status("1")
                    .build();
            BootcoinsRate bcr3=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("compra de bootcoins")
                    .typeOprations(StatusRate.PURCHASE)
                    .minimumCoins(101)
                    .maximumCoins(500)
                    .cost(BigDecimal.valueOf(4.00))
                    .status("1")
                    .build();
            BootcoinsRate bcr4=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("venta de bootcoins")
                    .typeOprations(StatusRate.SALE)
                    .minimumCoins(101)
                    .maximumCoins(500)
                    .cost(BigDecimal.valueOf(8.00))
                    .status("1")
                    .build();

            BootcoinsRate bcr5=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("compra de bootcoins")
                    .typeOprations(StatusRate.PURCHASE)
                    .minimumCoins(501)
                    .maximumCoins(1000)
                    .cost(BigDecimal.valueOf(4.00))
                    .status("1")
                    .build();
            BootcoinsRate bcr6=BootcoinsRate.builder()
                    .id(UUID.randomUUID().toString())
                    .description("venta de bootcoins")
                    .typeOprations(StatusRate.SALE)
                    .minimumCoins(501)
                    .maximumCoins(1000)
                    .cost(BigDecimal.valueOf(8.00))
                    .status("1")
                    .build();

            List.of(bcr1,bcr2,bcr3,bcr4,bcr5,bcr6)
                    .forEach(obj -> bcs.createBootcoinsRate(obj).subscribe());


        }
    }
}
