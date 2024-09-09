package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myorderhiber")
public class Myorder {

	@Id
	private String name;
	private String medName;
	private Double price,totalBill;
	private int quantity;
	public Myorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Myorder(String name, String medName, Double price, Double totalBill, int quantity) {
		super();
		this.name = name;
		this.medName = medName;
		this.price = price;
		this.totalBill = totalBill;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Myorder [name=" + name + ", medName=" + medName + ", price=" + price + ", totalBill=" + totalBill
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
