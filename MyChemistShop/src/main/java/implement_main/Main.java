package implement_main;

import java.util.Scanner;


import service.Service;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		Service s=new Service();
		
		
		
		
		while(true)
		{
			System.out.println("1. To add Medicine Detail.");
			System.out.println("2. To see all Medicine.");
			System.out.println("3. To remove a Medicine.");
			System.out.println("4. To search a Medicine by id.");
			System.out.println("5. To update name of Medicine.");
			System.out.println("6. To updae Price of Medicine.");
			System.out.println("7. To updae Stock of Medicine.");
			System.out.println("8. To Place an order");
			System.out.println("0. To Exit");
			int ch=sc.nextInt();
			
			
			if(ch==1)
			{
				if(s.addMedDetails())
				{
					System.out.println("Details added Successfully");
				}
				else
				{
					System.out.println("Please try again !!!");
				}
				
			}
			
			else if(ch==2)
			{
				s.showAll();
				
			}
			else if(ch==3)
			{
				
				if(s.remove())
				{
					System.out.println("Record removed Successfully");
				}
				
				
			}
			else if(ch==4)
			{	
				s.searchMed();
				
				
			}
			else if(ch==5)
			{
				if(s.updateMedName())
				{
					System.out.println("Name updated Successfully");
				}
				else
				{
					
					System.out.println("Please try again !!!");
				}
				
				
			}
			else if(ch==6)
			{
				if(s.updateMedPrice())
				{
					System.out.println("Price updated Successfully");
				}
				else
				{
					System.out.println("Please try again !!!");
				}
				
			}
			else if(ch==7)
			{
				if(s.updateMedStock())
				{
					System.out.println("Stock updated Successfully");
				}
				else
				{
					System.out.println("Please try again !!!");
				}
			}
			else if(ch==8)
			{	
				s.order();				
			}
			else if(ch==0)
			{
				break;
			}
			else
			{
				continue;
			}
			
		}
		
		
		
		
		
	}

}
