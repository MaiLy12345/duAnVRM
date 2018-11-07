package com.hellokoding.auth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private float don_gia;
	private float gia_tri;
	
	private String phapli;
	private String hientrang;
	@ManyToOne
	@JoinColumn(name="idc")
	private categoryProduct category;

	

	public Product() {
		super();
	}

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

	

	public float getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(float don_gia) {
		this.don_gia = don_gia;
	}

	public float getGia_tri() {
		return gia_tri;
	}

	public void setGia_tri(float gia_tri) {
		this.gia_tri = gia_tri;
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

	public categoryProduct getCategory() {
		return category;
	}

	public void setCategory(categoryProduct category) {
		this.category = category;
	}

	

}
