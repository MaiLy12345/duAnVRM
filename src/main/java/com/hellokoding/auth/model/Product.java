package com.hellokoding.auth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private Long id;
	private String diachi;
	private String thanhpho;
	private float dai;
	private float rong;
	private String gia;
	private String phapli;
	private String hientrang;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public void setDai(int dai) {
		this.dai = dai;
	}

	

	public float getDai() {
		return dai;
	}

	public void setDai(float dai) {
		this.dai = dai;
	}

	public float getRong() {
		return rong;
	}

	public void setRong(float rong) {
		this.rong = rong;
	}

	public void setRong(int rong) {
		this.rong = rong;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getPhapli() {
		return phapli;
	}

	public void setPhapli(String phapli) {
		this.phapli = phapli;
	}

	public String getHientrang() {
		return hientrang;
	}

	public void setHientrang(String hientrang) {
		this.hientrang = hientrang;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}

}
