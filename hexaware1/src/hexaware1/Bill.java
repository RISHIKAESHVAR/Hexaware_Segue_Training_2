package hexaware1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bill {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Double> products = new HashMap<>();
		products.put("juice", 89.98);
		products.put("biscuits", 39.98);
		products.put("pen", 9.98);
		products.put("marker", 59.98);
		products.put("eggs", 129.98);
		products.put("bread", 49.98);
		products.put("butter", 99.98);
		
		System.out.println("Enter the item you want from the list");
		for(String item : products.keySet())
		{
			Double price = products.get(item);
			System.out.println(item+"     "+price);
		}
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println("Enter Quantity");
		int i = s.nextInt();
		if(products.containsKey(str))
		{
			double amt = products.get(str) * i;
			System.out.println("Total : "+amt);
		}
		else
		{
			System.out.println("See the list and enter option.");

		}
	}

}