package com.hellokoding.auth.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="category")
public class categoryProduct {
	@Id
private Long idc;
private String name;

@OneToMany(mappedBy="category")
private List<Product> product;

public categoryProduct() {
	super();
}

public Long getIdc() {
	return idc;
}

public void setIdc(Long idc) {
	this.idc = idc;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}

}
