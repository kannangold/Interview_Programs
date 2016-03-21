package array.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NthLargestNumber {
	public static int findNthLargestNumber(int arr[], int number) // without removing duplicates
	{
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
		}
		System.out.println("The array is : " + Arrays.toString(arr));

		int count = 0;
		int large = 0;
		for (int i = 0; i < length; i++) {
			large = arr[i];
			count++;
			if (i == length - 1) 
				break;
			if (arr[i] == arr[i + 1]) 
				i++;
			if (count == number) 
				break;
		}
		
		/*for(int i=0;i<length;i++){
	    	if(i == length-1){
	    		large=arr[i];
	    		count++;
	    		break;
	    	}
	    	if(arr[i] == arr[i+1]){
	    		large = arr[i];
	    		count++;
	    		i++;
	    	}
	    	else{
	    		count++;
	    		large = arr[i];
	    	}
	    	if(count == number){
	    	  break;
	    	}
	    }*/
		if (count == number) {
			return large;
		} else {
			return -1;
		}
	}
	public static int findNthLargestNumber_1(int arr[], int number) // After removing duplicates
	{
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> data = new TreeSet<Integer>();
		for(int i : arr)
			data.add(i);
		System.out.println(Arrays.toString(data.toArray()));
		//list.addAll(data);
		//Collections.sort(list);
		//ListIterator<Integer> it = (ListIterator<Integer>) data.iterator();
		list.addAll(data);
		return list.get(list.size()-number);
	}
	public static void main(String[] args) {
		int[] arr = { 20, 11, 13, 15, 15,10, 12, 13, 7, 20, 10 };
		System.out.println("\nEnter the number for largest number: ");
		Scanner scr = new Scanner(System.in);
		int number = scr.nextInt();
		int large = findNthLargestNumber(arr, number);
		if (large != -1)
			System.out.println("The " + number + "th Largest number is : "
					+ large);
		else
			System.out.println("Please enter the number within array range");
		System.out.println("The " + number + "th Largest number is : " + findNthLargestNumber_1(arr,number));
	}

}
