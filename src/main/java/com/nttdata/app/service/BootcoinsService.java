package com.nttdata.app.service;

import com.nttdata.app.api.response.BootcoinsResponse;
import com.nttdata.app.documents.BootcoinsRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinsService {

    Mono<String> createBootcoinsRate(BootcoinsRate bootcoins);
    Flux<BootcoinsResponse>getAllActiveBootcoinsRate();
    Mono<Long> count();

}
