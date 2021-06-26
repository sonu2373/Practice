package Grocery;

import java.util.ArrayList;
import java.util.Scanner;

public class Grocery_Main {
	private static Scanner scanner=new Scanner(System.in);
	private static Grocery_List grocery_List=new Grocery_List();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit=false;
		int choice=0;
		printIntructions();
		while (!quit) {
			System.out.println("Enter your choice");
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 0:
				printIntructions();				
				break;
			case 1:
				grocery_List.printGroceryItem();
				break;
			case 2:
				addItem();
				break;
			case 3: 
				modifyItem();
				break;
			case 4: 
				removeItem();
				break;
			case 5: 
				searchForItem();
				break;
			case 6:
				processArrayList();
				break;
			case 7:
				quit=true;
				break;
			}
			
		}
	
	}
	public static void printIntructions()
	{
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To modify an item in the list.");
		System.out.println("\t 4 - To remove an item from the list.");
		System.out.println("\t 5 - To search item in the list.");
		System.out.println("\t 6 - To quit the application.");
		
	}
	
	public static void addItem()
	{
		System.out.println("Please enter the grocery item");
		grocery_List.addGroceryItem(scanner.nextLine());
	}
	
	public static void modifyItem()
	{
		System.out.println("Enter item name: ");
		String currentItem=scanner.nextLine(); 
		System.out.println("Enter replacement item:");
		String newItem=scanner.nextLine();
		grocery_List.modifyGroceryItem(currentItem, newItem);
	}
	
	public static void removeItem()
	{
		
		System.out.println("Enter item name: ");
		String itemName=scanner.nextLine();
		grocery_List.removeGroceryItem(itemName);
	}
	
	public static void searchForItem()
	{
		System.out.println("Item to search For: ");
		String searchItem=scanner.nextLine();
		if(grocery_List.onFile(searchItem))
		{
			System.out.println("Found: "+searchItem+" in our grocery list");
		}
		else {
			System.out.println(searchItem+" is not in the grocery list");
			
		}
	}
	
	public static void processArrayList()
	{
		ArrayList<String> newArray=new ArrayList<>();
		newArray.addAll(grocery_List.getGroceryList());
		
		ArrayList<String> nextArray=new ArrayList<>(grocery_List.getGroceryList());
		
		String[] myArray=new String[grocery_List.getGroceryList().size()];
		myArray=grocery_List.getGroceryList().toArray(myArray);
	}
}
