package com.example.EmpSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
@Id

private int pid;
private String pname;
private int price;
private int quntity;
@ManyToOne
@JoinColumn
private Category category;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuntity() {
	return quntity;
}
public void setQuntity(int quntity) {
	this.quntity = quntity;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
@Override
public String toString() {
	return "Products [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quntity=" + quntity + "]";
}
public Products(int pid, String pname, int price, int quntity, Category category) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.quntity = quntity;
	this.category = category;
}
public Products() {
	super();
	
}


}
