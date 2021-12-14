package com.chinmay.basics;

import java.util.Arrays;

public class BooleanArrays {

//	public static boolean compare(boolean[] arr1,boolean[] arr2) {
//		boolean result;
//		for(int i=0;i<arr1.length;i++) 
//			if(arr1[i]!=arr2[i]) 
//			result= false;
//			return result;
//		
//	}

	public static void main(String[] args) {
		boolean[] blnArray1 = new boolean[] {true,false,true};
		boolean[] blnArray2 = new boolean[] {true,false,true};
		
		/*if(blnArray1==blnArray2) 
			System.out.println("Same");
		else 
			System.out.println("Not Same");*/
			
		
//		System.out.println("Same Array ? " +compare(blnArray1,blnArray1));
		
		boolean blnResult = Arrays.equals(blnArray1, blnArray2);
		System.out.println("Boolean Array Matched ? : " +blnResult);
	}
}
