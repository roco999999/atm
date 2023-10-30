package com.example.atmsimulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmsimulation.service.AtmService;

@RestController
@RequestMapping("/api/atm")
public class AtmController {
    @Autowired
    private AtmService atmService;

    @PostMapping("/paraYatir")
    public ResponseEntity<Void> paraYatir(@RequestParam Long hesapId, @RequestParam Double miktar) {
        atmService.paraYatir(hesapId, miktar);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/paraCek")
    public ResponseEntity<Void> paraCek(@RequestParam Long hesapId, @RequestParam Double miktar) {
        atmService.paraCek(hesapId, miktar);
        return ResponseEntity.ok().build();
    }
}
