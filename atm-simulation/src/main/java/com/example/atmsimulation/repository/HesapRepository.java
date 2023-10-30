package com.example.atmsimulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atmsimulation.model.Hesap;

public interface HesapRepository extends JpaRepository<Hesap, Long> {
}
