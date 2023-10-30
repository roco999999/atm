package com.example.atmsimulation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HesapHareket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Hesap hesap;
    private Double miktar;
    private String tip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hesap getHesap() {
		return hesap;
	}
	public void setHesap(Hesap hesap) {
		this.hesap = hesap;
	}
	public Double getMiktar() {
		return miktar;
	}
	public void setMiktar(Double miktar) {
		this.miktar = miktar;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

    
    
}