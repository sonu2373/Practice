package mobile_phone;

import java.util.Scanner;

public class main {
	private static Scanner scanner=new Scanner(System.in);
	private static mobile mobile=new mobile("00393304404");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit=false;
		startPhone();
		printActions();
		while(!quit)
		{
			System.out.println("\nEnter action: (6 to show available actions) ");
			int action=scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("\nShutting down...");
				quit=true;
				break;
				
			case 1:
				mobile.printContacts();
				break;
				
			case 2:
				addNewContact();
				break;
				
			case 3:
				updateContact();
				break;
			
			case 4:
				removeContact();
				break;
		
			case 5:
				queryContact();
				break;
				 
			case 6:
				printActions();
				break;
				
		
			}
		}
	}
	
	
	
	private static void queryContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter existing contact name:");
		String name=scanner.nextLine();
		Contacts existContacts=mobile.queryContact(name);
		if(existContacts==null)
		{
			System.out.println("Conatct not found");
			return; 
		}
		
		System.out.println("Name: "+existContacts.getName()
		+"	phone: "+existContacts.getPhoneNumber());
	}



	private static void removeContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter existing contact name:");
		String name=scanner.nextLine();
		Contacts existContacts=mobile.queryContact(name);
		if(existContacts==null)
		{
			System.out.println("Conatct not found");
			return; 
		}
		
		if(mobile.removeContact(existContacts))
			System.out.println("Succesfully delted");
		else {
			System.out.println("Error deleting contact");
		}
	}



	private static void updateContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter existing contact name:");
		String name=scanner.nextLine();
		Contacts existContacts=mobile.queryContact(name);
		if(existContacts==null)
		{
			System.out.println("Conatct not found");
			return; 
		}
		
		System.out.println("Enter new contact name");
		String newName=scanner.nextLine();
		System.out.println("Enter new phone number");
		String newNumber=scanner.nextLine();
		Contacts newcontact=Contacts.createContact(newName, newNumber);
		if(mobile.updateContact(existContacts, newcontact))
		System.out.println("Successfully updated record");
		else {
			System.out.println("Error updating contact");
		}
	}



	private static void addNewContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter new contact name:");
		String name=scanner.nextLine();
		System.out.println("Enter phone number");
		String phone=scanner.nextLine();
		Contacts newContacts=Contacts.createContact(name,phone);
		
		if(mobile.addNewContacts(newContacts))
		{
			System.out.println("New contact added: "+name+" , phone = "+phone);
		}
		else {
			{
				System.out.println("cannot add, "+name +" already on a file");
			}
		}
	}



	private static void startPhone()
	{
		System.out.println("Starting phone...");
	}
	
	private static void printActions() {
		System.out.println("\nAvailable action:\npress");
		System.out.println("0 - to shutdown\n"+
							"1 - ro print contacts\n"+
							"2 - to add a new contact\n"+
							"3 - to update an existing contact\n"+
							"4 - to remove an existing contact\n"+
							"5 - query if an existing contact exists\n"+
							"6 - to print a list of available actions");
		System.out.println("Choose your actions: ");
	}
}
