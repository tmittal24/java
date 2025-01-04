package com.yogi.array.ex1;

import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.lang.ArrayUtils;

public class SubArrIndexTest {
	public static void main(String[] args) {
		SubArrIndexTest test = new SubArrIndexTest();
		
		int[] arr = {4,9,3,7,8};
		int[] subArr = {9,3,7};
		
		
		int index = test.findSubArrIndex(arr, subArr );
		System.out.println(index);//prints 1
		
		
		int[] arr1 = {4,9,8,7,8};
		int[] subArr1 = {8,7};
		
		index = findArray(arr1,subArr1);
		System.out.println(index);//prints 2
		
		
		
	}

	public static int findArray(int[] arr1, int[] subArray)
	{
		Integer[] newArray1 = ArrayUtils.toObject(arr1);
		Integer[] newSubArray1 = ArrayUtils.toObject(subArray);
	    return Collections.indexOfSubList(Arrays.asList(newArray1), Arrays.asList(newSubArray1));
	}
	
	int findSubArrIndex(int[] arr,int[] subarr)
	{
	    int lim=arr.length-subarr.length;
	    int[] tmpArr=new int[subarr.length];
	    for(int i=0;i<=lim;i++)
	    {
	        System.arraycopy(arr,i,tmpArr,0,subarr.length);
	        if(Arrays.equals(tmpArr,subarr))
	          return i; //returns starting index of sub array
	    }
	    return -1;//return -1 on finding no sub-array   

	}
	
	

}

