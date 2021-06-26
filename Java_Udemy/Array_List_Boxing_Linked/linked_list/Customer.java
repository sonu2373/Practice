package linked_list;

import java.util.ArrayList;

class Customer1 {
	private String name;
	private double balance;
	
	public  Customer1(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
		
}


public class Customer
{
	public static void main(String[] args) {
		Customer1 customer=new Customer1("Sumit",12.3);
		Customer1 anothercustomer;
		anothercustomer=customer;
		
		anothercustomer.setBalance(12.18);
		System.out.println("Balance for customer "+customer.getName()+" is "+customer.getBalance());
		
	ArrayList<Integer> intList=new ArrayList<Integer>();
	
	intList.add(1);
	intList.add(3);
	intList.add(6);
	
	for (int i = 0; i < intList.size(); i++) {
		System.out.println(i+": "+intList.get(i));
	}
	
	intList.add(1,2);
	
	for (int i = 0; i < intList.size(); i++) {
		System.out.println(i+": "+intList.get(i));
	}
	
	
	}
}