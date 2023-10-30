package com.example.atmsimulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atmsimulation.model.HesapHareket;

public interface HesapHareketRepository extends JpaRepository<HesapHareket, Long> {
}
