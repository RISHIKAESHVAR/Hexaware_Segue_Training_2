package Dao;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.Connection;
import model.Chemist;
import model.Myorder;

public class Dao implements DaoInter {

	
	Scanner sc,sc1;
	SessionFactory f;
	public Dao()
	{
		f=Connection.getSessionFact();
		
		sc= new Scanner (System.in);
		sc1= new Scanner (System.in);
			
	}
	
	
	
	public boolean addDetails(Chemist c) {
		try
		{
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			ses.save(c);
			tx.commit();
			ses.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void showAllMed() {
		try
		{
			Session ses=f.openSession();
			
			Query q=ses.createQuery("from Chemist");
			List <Chemist> li=q.list();
			
			for(Chemist i: li)
			{
				System.out.print("Med_ID: "+i.getmId());
				System.out.print(" | Name: "+i.getMedName());
				System.out.print(" | Price: "+i.getPrice());
				System.out.print(" | Stock: "+i.getStock());
				System.out.println();
			}
			ses.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public boolean removeMed(Chemist c) {
		
		try {
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			Chemist obj=ses.find(Chemist.class, c.getmId());
			if(obj!=null)
			{
				ses.delete(obj);
				tx.commit();
				ses.close();
				
				return true;
			}
			else
			{
				System.out.println("Record not found");
				return false;
			}
			
			
			
		}
		catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
		
	}

	
	public void searchMed(Chemist c) {
		try {
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			Chemist obj=ses.find(Chemist.class, c.getmId());
			if(obj!=null)
			{
				
				System.out.print("Med_ID: "+obj.getmId());
				System.out.print(" | Name: "+obj.getMedName());
				System.out.print(" | Price: "+obj.getPrice());
				System.out.print(" | Stock: "+obj.getStock());
				System.out.println();
			}
			else
			{
				System.out.println("Record not found");
			}
			ses.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}



	public boolean updateName(Chemist c) {
		try {
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			
			Chemist obj=ses.find(Chemist.class, c.getmId());
			
			if(obj!=null)
			{
				System.out.println("Enter the new Name");
				String newName=sc1.nextLine();
				
				
				obj.setMedName(newName);
				ses.update(obj);
				tx.commit();
				ses.close();
				
				return true;
			}
			else
			{
				System.out.println("Record not found !!");
				return false;
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}



	public boolean updatePrice(Chemist c) {
		try {
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			Chemist obj=ses.find(Chemist.class, c.getmId());
			
			if(obj!=null)
			{
				System.out.println("Enter the new Price: ");
				Double pr=sc.nextDouble();
				obj.setPrice(pr);
				ses.update(obj);
				tx.commit();
				ses.close();
				
				return true;
			}
			else
			{
				System.out.println("Record not found !!");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}



	public boolean updateStock(Chemist c) {
		try {
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			Chemist obj=ses.find(Chemist.class, c.getmId());
			if(obj!=null)
			{
				System.out.println("Enter Quantity: ");
				int q=sc.nextInt();
				obj.setStock(obj.getStock()+q);
				ses.update(obj);
				tx.commit();
				ses.close();
				
				return true;
			}
			else
			{
				System.out.println("Record not found");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}



	public void order(Chemist c) {
		
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		Query<Chemist> q= ses.createQuery("from Chemist where medName=:x ");
		q.setParameter("x", c.getMedName());
		Chemist obj=q.uniqueResult();
		if(obj!= null)
		{
			System.out.println("Enter Quantity : ");
			int quan= sc.nextInt();
			
			if(obj.getStock()>=quan)
			{
				
				while(true)
				{
					System.out.println("Press 1 to confirm order, Press 2 to cancel order");
					int choice=sc.nextInt();
					
					if(choice==1)
					{
						System.out.println("Enter your patient name : ");
						String nm=sc1.nextLine();
						
						Myorder order=new Myorder();
						order.setMedName(obj.getMedName());
						order.setName(nm);
						order.setPrice(obj.getPrice());
						order.setQuantity(quan);
						order.setTotalBill(obj.getPrice()*quan);
						
						ses.save(order);
						
						obj.setStock(obj.getStock()-quan);
						ses.update(obj);
						tx.commit();
						
						
						Myorder obj1=ses.find(Myorder.class, nm);
						
						
						System.out.println("MY CHEMIST SHOP");
						System.out.println("Name: "+obj1.getName());
						System.out.print("Medicine : "+obj1.getMedName());
						System.out.print(" | Price : "+obj1.getPrice());
						System.out.print(" | Quantity : "+obj1.getQuantity());
						System.out.print(" | Total: "+obj1.getTotalBill());
						System.out.println("");
						
						ses.close();
						break;
						
						
					}
					else if(choice==2)
					{
						break;
					}
					else continue;
					
					
				}
			}
			else System.out.println("Medicine out of Stock");
			
		}
		else System.out.println("Medicine not found.");
	}

	

	

	
	

	
	
	
}
