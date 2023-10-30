package com.example.atmsimulation.service;

import org.springframework.stereotype.Service;

@Service
public interface AtmService {
    void paraYatir(Long hesapId, Double miktar);
    void paraCek(Long hesapId, Double miktar);
}
