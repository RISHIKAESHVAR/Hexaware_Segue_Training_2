package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medtab")
public class Chemist {

	@Column(name="MedID")
	@Id
	private int mId;
	
	@Column(name="Name")
	private String medName;
	
	@Column(name="Price")
	private Double price;
	
	@Column(name="Stock")
	private int stock;
	
	public Chemist()
	{
		mId=0;
		medName="";
		price=0.0;
		stock=0;
		
	}
	
	public Chemist(int mId, String medName, Double price, int stock) {
		super();
		this.mId = mId;
		this.medName = medName;
		this.price = price;
		this.stock = stock;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Chemist [mId=" + mId + ", medName=" + medName + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
}
