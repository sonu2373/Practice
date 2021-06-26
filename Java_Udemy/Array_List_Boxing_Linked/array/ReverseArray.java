package array;

import java.util.Arrays;

import java.util.Scanner;

public class ReverseArray {

	private static void reverse(int[] array)
	{
		int temp;
		for(int i=0;i<array.length/2;i++)
		{
			temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] array=new int[5];
		for(int i = 0; i<array.length; i++) {
            System.out.println("Enter a number:");
            int number = sc.nextInt();
            sc.nextLine();
            array[i] = number;
        }
		System.out.println(Arrays.toString(array));
		reverse(array);
		System.out.println(Arrays.toString(array));
	}

}
