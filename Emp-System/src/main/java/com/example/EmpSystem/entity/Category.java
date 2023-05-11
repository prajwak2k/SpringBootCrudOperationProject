package com.example.EmpSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cid;
private String name;

@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
@JsonIgnore
private List<Products> products;
public Category() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Products> getProducts() {
	return products;
}
public void setProducts(List<Products> products) {
	this.products = products;
}
@Override
public String toString() {
	return "Category [cid=" + cid + ", name=" + name + "]";
}
public Category(int cid, String name, List<Products> products) {
	super();
	this.cid = cid;
	this.name = name;
	this.products = products;
}

}
