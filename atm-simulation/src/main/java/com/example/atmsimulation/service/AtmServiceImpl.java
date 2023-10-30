package com.example.atmsimulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.atmsimulation.model.Hesap;
import com.example.atmsimulation.model.HesapHareket;
import com.example.atmsimulation.repository.HesapHareketRepository;
import com.example.atmsimulation.repository.HesapRepository;

@Service
public class AtmServiceImpl implements AtmService {
    @Autowired
    private HesapRepository hesapRepository;
    @Autowired
    private HesapHareketRepository hesapHareketRepository;

    @Override
    @Transactional
    public void paraYatir(Long hesapId, Double miktar) {
        Hesap hesap = hesapRepository.findById(hesapId).orElseThrow(() -> new RuntimeException("Hesap bulunamadi"));
        hesap.setBakiye(hesap.getBakiye() + miktar);
        hesapRepository.save(hesap);

        HesapHareket hareket = new HesapHareket();
        hareket.setHesap(hesap);
        hareket.setMiktar(miktar);
        hareket.setTip("Giris");
        hesapHareketRepository.save(hareket);
    }

    @Override
    @Transactional
    public void paraCek(Long hesapId, Double miktar) {
        Hesap hesap = hesapRepository.findById(hesapId).orElseThrow(() -> new RuntimeException("Hesap bulunamadi"));
        if (hesap.getBakiye() < miktar) {
            throw new RuntimeException("Yetersiz bakiye");
        }
        hesap.setBakiye(hesap.getBakiye() - miktar);
        hesapRepository.save(hesap);

        HesapHareket hareket = new HesapHareket();
        hareket.setHesap(hesap);
        hareket.setMiktar(miktar);
        hareket.setTip("Cikis");
        hesapHareketRepository.save(hareket);
    }
}
