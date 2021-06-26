package linked_list;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		LinkedList<String> placestoVisit=new LinkedList<String>();
		
		addInOrder(placestoVisit, "Mumbai");
		addInOrder(placestoVisit, "America");
		addInOrder(placestoVisit, "Japan");
		addInOrder(placestoVisit, "Thailand");
		addInOrder(placestoVisit, "Bangkok");
		addInOrder(placestoVisit, "Singapore");
		addInOrder(placestoVisit, "Saudi Arabia");
		addInOrder(placestoVisit, "Canada");

		printList(placestoVisit);
		
		addInOrder(placestoVisit, "Korea");
		addInOrder(placestoVisit, "Bangkok");
		printList(placestoVisit);
		visit(placestoVisit);
		/*
		placestoVisit.add(1,"Banglore");
		printList(placestoVisit);
		
		placestoVisit.remove(4);
		printList(placestoVisit);*/
	}

	private static void printList(LinkedList<String> linkedList) {
		// TODO Auto-generated method stub
		Iterator<String> i=linkedList.iterator();
		while (i.hasNext()) {
			System.out.println("Now visiting: "+i.next());
		}
		System.out.println("===========================");			
	}
	
	private static boolean addInOrder(LinkedList<String> linkedList,String newCity) 
	{
		ListIterator<String> stringListIterator=linkedList.listIterator();
		
		while (stringListIterator.hasNext()) {
			int comparison=stringListIterator.next().compareTo(newCity);
			if(comparison==0)
			{//equal,not add
				System.out.println(newCity+" is already included as a destination");			
				return false;
			}	
			else if(comparison>0)
			{
				//new city should appear before this one
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			}
			else if (comparison<0) {
				//move on next city
			}
		 }
			
		stringListIterator.add(newCity);
		return true;
		
	}
	
	private static void visit(LinkedList cities) {
		Scanner scanner=new Scanner(System.in);
		boolean quit=false;
		boolean goingForward=true;
		ListIterator<String> listIterator=cities.listIterator();
		
		if (cities.isEmpty()) {
			System.out.println("No cities in the itineary");
			return;
		}
		else {
			System.out.println("Now visiting "+listIterator.next());
			printMenu();			
		}
		
		while(!quit)
		{
			int action=scanner.nextInt();
			scanner.nextLine();
			switch (action) {
				case 0:
					System.out.println("Holiday (Vacation) over");
					quit=true;
					break;
				case 1:
					if(!goingForward)
					{
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						goingForward=true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now visiting "+listIterator.next());
					} else {
						System.out.println("Reached the end of the list");
						goingForward=false;
					}
					break;
				case 2:
					if(goingForward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						goingForward=false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now visiting "+listIterator.previous());
					}
					else {
						System.out.println("we are the start of the list");
						goingForward=true;
					}
					break;
				case 3:
					printMenu();
					break;
			}
		}
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Available action:\npress ");
		System.out.println("0 - to quit\n"+
							"1 - go to next city\n"+
							"2 - go to previous city\n"+
							"3 - print menu");
	}
}
