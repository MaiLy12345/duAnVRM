package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
    private Long id;
    private String username;
    private String password;
    private String name;
    private String gioitinh;
    private String cmnd;
    private String sdt;
    private String diachi;
    private String namsinh;
    private String quequan;
    private String vitricongviec;
    private String chuyenmon;
    private String thoigianvao;
    private String thoigiannghi;
    private boolean trangThai;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getVitricongviec() {
		return vitricongviec;
	}

	public void setVitricongviec(String vitricongviec) {
		this.vitricongviec = vitricongviec;
	}

	public String getChuyenmon() {
		return chuyenmon;
	}

	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}

	public String getThoigianvao() {
		return thoigianvao;
	}

	public void setThoigianvao(String thoigianvao) {
		this.thoigianvao = thoigianvao;
	}

	public String getThoigiannghi() {
		return thoigiannghi;
	}

	public void setThoigiannghi(String thoigiannghi) {
		this.thoigiannghi = thoigiannghi;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
    
    
}
