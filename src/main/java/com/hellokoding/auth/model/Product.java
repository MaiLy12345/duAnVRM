package com.hellokoding.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "loai")
	private String loai;

	@Column(name = "ngaytao")
	private String ngaytao;

	@Column(name = "maSpdu")
	private String maSpdu;// mã sản phẩm dự án

	@Column(name = "diachi")
	private String diachi;

	@Column(name = "phuongxa")
	private String phuongxa;

	@Column(name = "quanhuyen")
	private String quanhuyen;

	@Column(name = "thanhpho")
	private String thanhpho;

	@Column(name = "dai")
	private float dai;

	@Column(name = "rong")
	private float rong;

	@Column(name = "dientich")
	private float dientich;

	@Column(name = "huong") // danh cho nha ban va nha cho thue
	private String huong;

	@Column(name = "dongia")
	private float dongia;

	@Column(name = "giatri")
	private float giatri;

	@Column(name = "phapli")
	private String phapli;

	@Column(name = "hientrang")
	private String hientrang;

	@Column(name = "clip") // danh cho nha ban va nha cho thue
	private String clip;

	@ManyToOne
	@JoinColumn(name = "Maduan") // danh cho nha trong du an
	private Category category;

	public Product() {
		super();
	}

	// getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getMaSpdu() {
		return maSpdu;
	}

	public void setMaSpdu(String maSpdu) {
		this.maSpdu = maSpdu;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}

	public String getQuanhuyen() {
		return quanhuyen;
	}

	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public String getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
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

	public float getDientich() {
		return dientich;
	}

	public void setDientich(float dientich) {
		this.dientich = dientich;
	}

	public String getHuong() {
		return huong;
	}

	public void setHuong(String huong) {
		this.huong = huong;
	}

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public float getGiatri() {
		return giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
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

	public String getClip() {
		return clip;
	}

	public void setClip(String clip) {
		this.clip = clip;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
