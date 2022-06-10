package com.nttdata.app.controller;

import com.nttdata.app.api.response.BootcoinsResponse;
import com.nttdata.app.service.impl.BootcoinsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rates")
public class BootcoinsController {

    @Autowired
    private BootcoinsServiceImpl bcsi;

    @GetMapping(value = "/active",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BootcoinsResponse>getActiveBootcoinsRatesList(){
        return bcsi.getAllActiveBootcoinsRate();
    }



}
