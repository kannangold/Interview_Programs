package string.sample;

import java.util.Arrays;

public class PrintSeries {
	public static void main(String a[])
	{ 
		System.out.println("A11B19C2 = " + getString("A11B19C2"));
		System.out.println("AD4BCZ8C11DQQQ2 = " + getParseString("AD4BCZ8C11DQQQ2"));
	}
	public static String getString(String str) //  with Split regex
	{
		StringBuilder sb = new StringBuilder("");
		if(str.equals(""))
			return sb.toString();
		String[] chars = str.split("[\\d]");
		String[] digits = str.split("[\\D]");
		System.out.println(Arrays.toString(chars));
		System.out.println(Arrays.toString(digits));
		chars  = clean(chars);
		digits  = clean(digits);
		for(int i=0;i<chars.length;i++)
		{
			for(int j=0;j<Integer.parseInt(digits[i]);j++)
				sb.append(chars[i]);
		}
		return sb.toString();
	}
	public static String getParseString(String str) //  without Split regex
	{
		StringBuilder sb = new StringBuilder("");
		if(str.equals(""))
			return sb.toString();
		int i=0;
		while(i < str.length())
		{
			String word = "",count="";
			char c = str.charAt(i);
			while(!Character.isDigit(c))
			{
				word += c;
				i++;
				if(i == str.length())
					break;
				c = str.charAt(i);
			}
			while(Character.isDigit(c))
			{
				count += c;
				i++;
				if(i == str.length())
					break;
				c = str.charAt(i);
			}
			for(int j=0;j<Integer.parseInt(count);j++)
				sb.append(word);
		}
		return sb.toString();
	}
	public static String[] clean(String[] data)
	{
		String s = "";
		for(int i=0;i<data.length;i++)
		{
			if(!data[i].isEmpty())
			{
				s += data[i];
				if(i != data.length-1)
					s += ",";
			}			
		}
		//System.out.println(s);
		return s.split(",");
	}
}
