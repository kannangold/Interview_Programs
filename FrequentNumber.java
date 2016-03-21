package array.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequentNumber {

	public static List<Integer> findFrequestNumbers(int arr[]) {
		int max = 0;
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (mp.containsKey(i)) {
				mp.put(i, mp.get(i) + 1);
				if (max < mp.get(i))
					max = mp.get(i);
			} else {
				mp.put(i, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			if (entry.getValue() >= max) {
				list.add(entry.getKey());
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the no of digits in array ");
		Scanner scr = new Scanner(System.in);
		int length = scr.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the data for array ");
		for (int i = 0; i < length; i++) {
			arr[i] = scr.nextInt();
		}
		List<Integer> list = findFrequestNumbers(arr);
		System.out.println(" Frequent Numbers : "
				+ Arrays.toString(list.toArray()));
	}

}
