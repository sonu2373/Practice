package mobile_phone;

import java.util.ArrayList;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

public class mobile {
	private String myNumber;
	private ArrayList<Contacts> myContacts;
	
	public mobile(String myNumber)
	{
		this.myNumber=myNumber;
		this.myContacts=new ArrayList<Contacts>();
	}
	
	public boolean addNewContacts(Contacts contact)
	{
		if(findContact(contact.getName())>=0)
		{
			System.out.println("Contact is already on file");
			return false;
		}
		
		myContacts.add(contact);
		return true;
	}
	
	public boolean updateContact(Contacts oldcontact,Contacts newcontact )
	{
		int foundposition=findContact(oldcontact);
		if(foundposition<0)
		{
			System.out.println(oldcontact.getName()+", was not found");
			return false;
		}
		else {
			if(findContact(newcontact.getName())!=-1)
			{
				System.out.println("Contact with name: "+newcontact.getName()+
						" already exist. Update was not successful.");
				return false;
			}
		}
		
		this.myContacts.set(foundposition, newcontact);
		System.out.println(oldcontact.getName()+", was replaced with "+newcontact.getName());
		return true;
	}
	
	public boolean removeContact(Contacts contact)
	{
		int foundposition=findContact(contact);
		if(foundposition<0)
		{
			System.out.println(contact.getName()+", was not found");
			return false;
		}
		this.myContacts.remove(foundposition);
		System.out.println(contact.getName()+", was deleted");
		return true;
	}
	
	
	private int findContact(Contacts contact)
	{
		return this.myContacts.indexOf(contact);
	}
	
	private int findContact(String contactName)
	{
		for (int i = 0; i < this.myContacts.size(); i++) {
			Contacts contact=this.myContacts.get(i);
			if(contact.getName().equals(contactName))
			{
				return i;
			}
		}
		return -1;
	}
	
	public String queryContact(Contacts contact)
	{
		if(findContact(contact)>=0)
		{
			return contact.getName();
		}
		return null;
	}
	
	public Contacts  queryContact(String name)
	{
		int position=findContact(name);
		if(position>=0)
		{
			return this.myContacts.get(position);
		}
		return null;
	}
	
	public void printContacts()
	{
		System.out.println("Contacts list");
		for (int i = 0; i < this.myContacts.size(); i++) {
			System.out.println((i+1)+"."+
										this.myContacts.get(i).getName()+" -> "+
											this.myContacts.get(i).getPhoneNumber());
		}
	}
}
