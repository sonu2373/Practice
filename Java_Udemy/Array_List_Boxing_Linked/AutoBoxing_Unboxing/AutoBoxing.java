package AutoBoxing_Unboxing;

import java.util.ArrayList;

public class AutoBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> intArrayList=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			intArrayList.add(Integer.valueOf(i));
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i+" --> "+intArrayList.get(i).intValue());
			
		}
		
		Integer myIntValue=56;//Integer.valueOf(56);
		int myInt=myIntValue;//myIntValue.intValue();
	}

}
