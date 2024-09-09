package hexaware1;

public class Bank {
	
	private int ActNo;
	private String Name;
	private Double Balance;
	
	
	 Bank()
	 {
	
	 }
	
	
	
	public Bank(int actNo, String name, Double balance) {
		super();
		ActNo = actNo;
		Name = name;
		Balance = balance;
	}
	public int getActNo() {
		return ActNo;
	}
	public void setActNo(int actNo) {
		ActNo = actNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	
	public void deposit(double deposit_amount) {
        if (deposit_amount > 0) {
            this.Balance += deposit_amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
	
	public void withdraw(double widthraw_amount) {
        if (widthraw_amount > 0) {
            if (this.Balance >= widthraw_amount) {
                this.Balance -= widthraw_amount;
                System.out.println("Withdrawal successful. New balance: " + this.Balance);
            } else {
                System.out.println("Insufficient funds in your account. Withdrawal denied.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
	
	public boolean transfer(Bank recieving_account, double transfer_amount) {
        if (transfer_amount > 0) {
            if (this.Balance >= transfer_amount) {
                this.Balance -= transfer_amount;
                recieving_account.deposit(transfer_amount);
                System.out.println("Transfer successful.");
                System.out.println("Sender's New Balance: " + this.Balance);
                System.out.println("Recipient's New Balance: " + recieving_account.getBalance());
                return true;
            } else {
                System.out.println("Insufficient funds for transfer.");
                return false;
            }
        } else {
            System.out.println("Transfer amount must be positive.");
            return false;
        }
    }
	
//	public static void removeAccount(Bank[] users, int c, int actNo) {
//	    int acc_to_remove = -1;
//
//	    for (int i = 0; i < c; i++) {
//	        if (users[i].getActNo() == actNo) {
//	        	acc_to_remove = i;
//	            break;
//	        }
//	    }
//
//	    if (acc_to_remove != -1) {
//	        for (int i = acc_to_remove; i < c - 1; i++) {
//	            users[i] = users[i + 1];
//	        }
//	        users[c - 1] = null;
//	        c--;
//	        System.out.println("Account removed successfully.");
//	    } else {
//	        System.out.println("Account not found.");
//	    }
//	}
	
	@Override
	public String toString() {
		return "Bank [ActNo=" + ActNo + ", Name=" + Name + ", Balance=" + Balance +"]";
	}
}