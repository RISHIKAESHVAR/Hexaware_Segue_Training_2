package service;

import java.util.Scanner;

import Dao.Dao;
import Dao.DaoInter;
import model.Chemist;

public class Service {

	
	Scanner sc,sc1;
	DaoInter di;
	Chemist c;
	
	public Service()
	{
		sc=new Scanner(System.in);
		sc1=new Scanner(System.in);
		di=new Dao();
		c=new Chemist();
		
	}
	public boolean addMedDetails() {
		
		System.out.println("Enter Medicine ID: ");
		int id=sc.nextInt();
		System.out.println("Enter Medicine Name: ");
		String n=sc1.nextLine();
		System.out.println("Enter the Price:");
		Double p=sc.nextDouble();
		System.out.println("Enter the Quantity: ");
		int q=sc.nextInt();
		
		Chemist c=new Chemist(id,n,p,q);
		
		if(di.addDetails(c))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	public void showAll() {
		
		di.showAllMed();
		
		
	}
	public boolean remove() {


		System.out.println("Enter ID to remove: ");
		int id=sc.nextInt();
		
		c.setmId(id);
		return(di.removeMed(c));
		
		
	}
	public void searchMed() {
		System.out.println("Enter ID : ");
		int id=sc.nextInt();
		
		c.setmId(id);
		di.searchMed(c);
		
	}
	public boolean updateMedName() {
		System.out.println("Enter ID : ");
		int id=sc.nextInt();
		
		c.setmId(id);
		return di.updateName(c);
		
	}
	public boolean updateMedPrice() {
		System.out.println("Enter ID : ");
		int id=sc.nextInt();
		
		c.setmId(id);
		return di.updatePrice(c);
		
	}
	public boolean updateMedStock() {
		System.out.println("Enter ID : ");
		int id=sc.nextInt();
		
		c.setmId(id);
		return di.updateStock(c);
		
	}
	public void order() {
		System.out.println("Enter Name : ");
		String nm=sc.nextLine();
		
		c.setMedName(nm);
		di.order(c);
		
	}

}




















