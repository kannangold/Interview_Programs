package string.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchParenthesis {
	// find the unmatched parenthesis position.
	// Remove the unmatched parenthesis
	static int flag;
	public static List<Integer> getPositionofUnmatchParenthesis(String str)
	{
		List<String> stack = new ArrayList<String>();
		List<Integer> stackIndex = new ArrayList<Integer>();
		List<Integer> indices = new ArrayList<Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == '(')
			{
				stack.add("(");
				stackIndex.add(i);
			}
			else if(str.charAt(i) == ')')
			{
				 if(stack.size() < 1)
		            indices.add(i);
		        else
		        	stack.remove(stack.size()-1);
				 	if(stackIndex.size() > 0)
				 		stackIndex.remove(stackIndex.size()-1);	
			}
		}
		while(stackIndex.size() > 0)
		{
			if(stackIndex.size() > 0)
				indices.add(stackIndex.remove(stackIndex.size()-1));
		}
		     
		return indices;
	}
	private static String getMatchParenthesis(String s) {
		System.out.println(s + s.length());
		List<Integer> in = getPositionofUnmatchParenthesis(s);
		String str = "";
		for(Integer i : in)
		{
			str = s.substring(0,i.intValue()) + s.substring(i.intValue()+1,s.length());
		}
		System.out.println(str + str.length());
		return str;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the String with Parenthesis : ");
		String s= sc.next();
		System.out.println("Un Matched position : " + Arrays.toString(getPositionofUnmatchParenthesis(s).toArray()));
		System.out.println("Correct String is : " + getMatchParenthesis(s));
	}

}
