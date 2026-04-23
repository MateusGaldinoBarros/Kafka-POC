package com.poc.kafka_poc.controller;

import com.poc.kafka_poc.service.ChuvaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChuvaController {
    private final ChuvaService chuvaService;

    public ChuvaController (ChuvaService chuvaService) {
        this.chuvaService = chuvaService;
    }

    @PostMapping("/chuva")
    public void ChuvaDetectada (@RequestBody String mensagem) {
        chuvaService.publicarEvento(mensagem);
    }

}
