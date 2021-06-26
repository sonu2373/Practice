package Linked_list_Playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()

public class main {
	
	private static ArrayList<Album> albums=new ArrayList<Album>();
			
	public static void main(String[] args) {
		Album albumn = new Album("Stormbringer","Deep purple");
		albumn.addSong("Stormbringer", 4.6);
		albumn.addSong("Love don't mean a thing", 4.22);
		albumn.addSong("Holy man", 4.3);
		albumn.addSong("Hold on", 5.6);
		albumn.addSong("Lady double dealer", 3.21);
		albumn.addSong("you can't do it right",6.23);
		albumn.addSong("High ball shooter", 4.27);
		albumn.addSong("The gypsy", 4.2);
		albums.add(albumn);
		
		albumn = new Album("For those about to rock","AC/DC");
		albumn.addSong("For those about to rock", 5.44);
		albumn.addSong("I put the finger on you",3.25);
		albumn.addSong("Lets go",3.45);
		albumn.addSong("Inject the venom", 3.33);
		albumn.addSong("Snowballed", 4.51);
		albumn.addSong("Evil walks",3.45);
		albumn.addSong("C.O.D", 5.12);
		albumn.addSong("Breaking the rules", 5.32);
		albumn.addSong("Night of the long knives",5.12);
		albums.add(albumn);
		
		
		LinkedList<Song> playList=new LinkedList<Song>();
		albums.get(0).addToPlaylist("you can't do it right", playList);
		albums.get(0).addToPlaylist("Holy man", playList);
		albums.get(0).addToPlaylist("Speed king", playList);//not exist
		albums.get(0).addToPlaylist(9, playList);
		albums.get(1).addToPlaylist(1, playList);
		albums.get(1).addToPlaylist(3, playList);
		albums.get(1).addToPlaylist(2, playList);
		albums.get(1).addToPlaylist(11, playList);
		
		play(playList);
	}

	private static void play(LinkedList<Song> playList)
	{	
		Scanner scanner=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator=playList.listIterator();
		if(playList.size()==0)
		{
			System.out.println("No songs in the playlist");
			return;
		}
		else {
			System.out.println("Now playing "+listIterator.next());
			printMenu();
		}
		 
		while(!quit) {
			int action=scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("Playlist Complete");
				quit=true;
				break;
			case 1:
				if(!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward=true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing "+listIterator.next().toString());
				}
				else {
					System.out.println("We have reached end of the playlist");
					forward=false;
				}
				break;
				
			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();						
					}
					forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}
				else {
					System.out.println("We have reached start of the playlist");
					forward=true;
				}
				break;
				
			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now re-playing "+listIterator.previous().toString());
						forward=false;
					}
					else {
						System.out.println("We are at the start of the playlist");
					}
				}
				else {
					if (listIterator.hasNext()) {
						System.out.println("Now playing re-playing "+listIterator.next().toString());
						forward=true;
					}
					else {
						System.out.println("We have reached the end of the list");
					}
				}
				break;
				
				case 4:
					printList(playList);
					break;
				
				case 5:
					printMenu();
					break;
				case 6:
					if(playList.size()>0) {
						listIterator.remove();
						if (listIterator.hasNext()) {
							System.out.println("Now playing "+listIterator.next());
						}
						else if (listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.previous());
						}
					}
					break;
			}
		}
	}

	private static void printList(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		Iterator<Song> iterator=playList.iterator();
		System.out.println("======================================================");
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
		System.out.println("======================================================");
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Available actions:\npress");
		System.out.println("0 -  to quit\n"+
							"1 - to play next song\n"+
							"2 - to play previous song\n"+
							"3 - to replay the current song\n"+
							"4 - to list song in playlist\n"+
							"5 - print available actions\n"+
							"6 - delete current song");
						
	}

}
