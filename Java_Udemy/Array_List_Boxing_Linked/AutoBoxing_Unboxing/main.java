package AutoBoxing_Unboxing;


public class main {
	
	public static void main(String[] args) {
		
	Bank bank=new Bank("INDIA BANK");
	
	bank.addBranch("Siwan");
	
	bank.addCustomer("Siwan", "Sumit", 1000);
	bank.addCustomer("Siwan", "Shailesh", 150);
	bank.addCustomer("Siwan", "Mithun", 500);
	bank.addCustomer("Siwan", "Ashutosh", 700);
	
	
	bank.addBranch("Mumbai");
	bank.addCustomer("Mumbai", "Prakash", 2000);
	bank.addCustomer("Mumbai", "Ankit", 1800);

	
	bank.addCustomerTransaction("Siwan","Shailesh" , 800);
	bank.addCustomerTransaction("Siwan","Mithun" , 400);
	bank.addCustomerTransaction("Siwan","Ashutosh" , 750);
	
	bank.listCustomers("Siwan", true);
	bank.listCustomers("Mumbai", true);
	
	bank.addBranch("Punjab");
	
	if(!bank.addCustomer("Punjab", "Priyanshu", 32))
		System.out.println("Error branch doesn't exist");
	
	bank.listCustomers("Punjab", true);
	
	if(!bank.addBranch("Siwan"))
		System.out.println(" Siwan Branch already exist");
	
	if (!bank.addCustomerTransaction("Siwan", "sonu", 23)); {
		System.out.println("Customer doesn't exist");
	}
	
	}	
	
}
