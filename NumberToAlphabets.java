package string.sample;

import java.util.Scanner;

public class NumberToAlphabets {
	/*To output the given string for the given input which is an integer.
	Input: 1
	Output: A
	Input: 26
	Output: Z
	Input : 27
	Output: AA
	Input: 28:
	Output: AB
	Input: 1000
	Output: ALL*/
	public static String convertToAlphabets(int number)
	{
		String output = "";
		while(number > 0)
		{
			int mod = number % 26;			
			number = number / 26;
			if(mod == 0)
			{
				mod = 26;
				number--;
			}
			mod += 64; // ASCII value of A = 65
			output = (char)mod + output;
		}
		return output;
	}
	public static void main(String a[])
	{
		System.out.println("1000 = " + convertToAlphabets(1000));
		System.out.println("24 = " + convertToAlphabets(24));
		System.out.println("267 = " + convertToAlphabets(267));
		System.out.println("52 = " + convertToAlphabets(52));
		System.out.println("78 = " + convertToAlphabets(78));
		System.out.println("28 = " + convertToAlphabets(28));
	}
	
	
	/*public static void printAlphabet(int input) {

		int rem = input;
		int quot = input;
		StringBuilder lett = new StringBuilder();

		if (input > 0) {
			while (rem > 26) {
				rem = rem / 26;
				quot = quot % 26;
				if (quot == 0) {
					quot = 26;
					rem = rem - 1;
				}
				lett.append(String.valueOf((char) (quot + 'A' - 1)));
				quot = rem;
			}
			if (rem <= 26) {
				lett.append(String.valueOf((char) (rem + 'A' - 1)));
			}
			lett.reverse();
			System.out.println("The letter is " + lett.toString());
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the Input Number ");
		Scanner scr = new Scanner(System.in);
		int number = scr.nextInt();
		printAlphabet(number);
	}*/
	
}
