package hexaware1;
 
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// array of object
		
	  
		Bank users[]=new Bank[100];
		int c=0;
		Scanner sc = new Scanner(System.in);
 
		
		while(true)
		{
		
		System.out.println("1......New Customer");
		System.out.println("2......show all ");
		System.out.println("3.......Deposit Amout");
		System.out.println("4.......Widthdraw ");
		System.out.println("5 Transfer Amount");
		System.out.println("6.search by account number");
		System.out.println("7.....Delete an account number");
		int ch=sc.nextInt();
		if (ch == 1) {
            boolean already_exist = false;
            System.out.println("Enter Account Number:");
            int actNo1 = sc.nextInt();
            
            for (int i = 0; i < c; i++) {
                if (users[i].getActNo() == actNo1) {
                	already_exist = true;
                    break;
                }
            }

            if (already_exist) {
                System.out.println("Account number already holded by another person");
            } else {
                users[c] = new Bank();
                System.out.println("Enter Name:");
                sc.nextLine();
                String name1 = sc.nextLine();
                System.out.println("Enter Balance:");
                double balance1 = sc.nextDouble();
                users[c].setActNo(actNo1);
                users[c].setName(name1);
                users[c].setBalance(balance1);
                c++;
            }
		}
		else if(ch==2)
		{
			
			for(int i=0;i<c;i++)
			{
				System.out.println(users[i].toString());
			}
		}
		else if (ch == 3) {
            System.out.println("Enter Account Number:");
            int actNo = sc.nextInt();
            boolean accountFound = false;
            for (int i = 0; i < c; i++) {
                if (users[i].getActNo() == actNo) {
                    System.out.println("Enter Amount to Deposit:");
                    double deposit_amount = sc.nextDouble();
                    users[i].deposit(deposit_amount);
                    System.out.println("Amount Deposited.");
                    accountFound = true;
                    break;
                }
            }
            if (!accountFound) {
                System.out.println("Account not found.");
            }

        } 
		else if(ch==4)
		{
			System.out.println("Enter Account Number:");
            int actNo = sc.nextInt();
            boolean accountFound = false;
            for (int i = 0; i < c; i++) {
                if (users[i].getActNo() == actNo) {
                    System.out.println("Enter Amount to Withdraw:");
                    double widthraw_amount = sc.nextDouble();
                    if (users[i].getBalance() >= widthraw_amount) {
                        users[i].withdraw(widthraw_amount);
                        System.out.println("Amount Withdrawn.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    accountFound = true;
                    break;
                }
            }
            if (!accountFound) {
                System.out.println("Account not found.");
            }
			
		}
		else if(ch==5)
		{
			 System.out.println("Enter Sending Account Number:");
             int sendingActNo = sc.nextInt();
             System.out.println("Enter Recieving Account Number:");
             int recievingActNo = sc.nextInt();
             boolean sendingAccountFound = false;
             boolean recievingAccountFound = false;
             Bank sendingAccount = null;
             Bank recievingAccount = null;

             for (int i = 0; i < c; i++) {
                 if (users[i].getActNo() == sendingActNo) {
                     sendingAccountFound = true;
                     sendingAccount = users[i];
                 }
                 if (users[i].getActNo() == recievingActNo) {
                     recievingAccountFound = true;
                     recievingAccount = users[i];
                 }
             }

             if (sendingAccountFound && recievingAccountFound) {
                 System.out.println("Enter Amount to Transfer:");
                 double amount = sc.nextDouble();
                 sendingAccount.transfer(recievingAccount, amount);
             } else {
                 if (!sendingAccountFound) {
                     System.out.println("Source account not found.");
                 }
                 if (!recievingAccountFound) {
                     System.out.println("Destination account not found.");
                 }
             }
			
		}
		else if(ch==6)
		{
			boolean account_details = true;
            System.out.println("Enter Account Number:");
            int actNo1 = sc.nextInt();
            int i;
            for (i = 0; i < c; i++) {
                if (users[i].getActNo() == actNo1) {
                	account_details = false;
                    break;
                }
            }
            if (account_details == false) {
            	System.out.println(users[i].toString());
            	
            }
            else {
            	System.out.println("Not found");
            	
            }
			
			
		}
		
		else if(ch==7) {
        	boolean removing_account=true;
        	int account_index=0;
        	System.out.println("enter Account Nnumber");
			    int ActNo1=sc.nextInt();
			 
			 for(int i=0;i<c;i++) {
				 if(users[i].getActNo()==ActNo1) {
					 removing_account=false;
					 account_index=i;
					 break;
				 }
			 }
			 if(removing_account) {
			 System.out.println("not found");
			 }
			 else {
				 for(int j=0;j<c;j++) {
					 users[j]=users[j+1];
				 
				 }
				 c=c-1;
				 System.out.println("Account Deleted");
			 }
		}
	}
}
}
