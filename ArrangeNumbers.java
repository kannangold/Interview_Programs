package array.sample;

import java.util.Arrays;

public class ArrangeNumbers {
	// Arranging Odd numbers in the odd position and even numbers in the even
	// position
	public static int[] arrangeNumbers(int a[]) 
	{
		System.out.println("Input : " + Arrays.toString(a));
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i; j < a.length; j++) 
			{
				if (a[j] % 2 == (i + 1) % 2) 
				{
					if (i == j) {
						break;
					} else {
						a[i] = a[i] + a[j];
						a[j] = a[i] - a[j];
						a[i] = a[i] - a[j];
						break;
					}
				}
			}
		}
		return a;
	}

	public static void main(String s[]) {
		// int a[] = {2,1,3,2,4,5,2,1}; // 1,2,3,2,5,4,1,2
		int a[] = { 3,4,2,3,5,6,2}; // 1,2,3,2,5,4,1,2
		// int a[] = {22,33,22,22,22,44};
		a = ArrangeNumbers.arrangeNumbers(a);
		System.out.println("Output : " + Arrays.toString(a));
		// display(a);
	}
}
