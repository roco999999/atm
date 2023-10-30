package com.example.atmsimulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.atmsimulation.model.Hesap;
import com.example.atmsimulation.repository.HesapHareketRepository;
import com.example.atmsimulation.repository.HesapRepository;
import com.example.atmsimulation.service.AtmService;

@SpringBootTest
public class AtmServiceTest {
    @Autowired
    private AtmService atmService;
    @Autowired
    private HesapRepository hesapRepository;
    @Autowired
    private HesapHareketRepository hesapHareketRepository;

    @Test
    void testParaYatir() {
        Hesap hesap = new Hesap();
        hesap.setAdi("Test Hesap");
        hesap.setBakiye(0.0);
        hesap = hesapRepository.save(hesap);

        atmService.paraYatir(hesap.getId(), 100.0);

        Hesap updatedHesap = hesapRepository.findById(hesap.getId()).orElse(null);
        assertNotNull(updatedHesap);
        assertEquals(100.0, updatedHesap.getBakiye());
    }

    @Test
    void testParaCek() {
        Hesap hesap = new Hesap();
        hesap.setAdi("Test Hesap");
        hesap.setBakiye(100.0);
        hesap = hesapRepository.save(hesap);

        atmService.paraCek(hesap.getId(), 50.0);

        Hesap updatedHesap = hesapRepository.findById(hesap.getId()).orElse(null);
        assertNotNull(updatedHesap);
        assertEquals(50.0, updatedHesap.getBakiye());
    }
}
