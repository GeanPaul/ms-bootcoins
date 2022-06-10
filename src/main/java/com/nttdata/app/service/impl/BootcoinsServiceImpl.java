package com.nttdata.app.service.impl;

import com.nttdata.app.api.response.BootcoinsResponse;
import com.nttdata.app.documents.BootcoinsRate;
import com.nttdata.app.repository.BootcoinsRepository;
import com.nttdata.app.service.BootcoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinsServiceImpl implements BootcoinsService {

    private final BootcoinsRepository bcrepo;


    @Override
    public Mono<String> createBootcoinsRate(BootcoinsRate bootCoins) {
        return bcrepo.save(bootCoins).map(obj -> obj.getId());
    }

    @Override
    public Flux<BootcoinsResponse> getAllActiveBootcoinsRate() {
        return bcrepo.findAll()
                .filter(BootcoinsRate::isActive)
                .map(obj -> BootcoinsResponse.builder()
                        .id(obj.getId())
                        .typeOprations(obj.getTypeOprations())
                        .minimumCoins(obj.getMinimumCoins())
                        .maximumCoins(obj.getMaximumCoins())
                        .cost(obj.getCost())
                        .build());
    }

    @Override
    public Mono<Long> count() {
        return  bcrepo.count();
    }
}
