package string.sample;

public class FindPatternCount {
	public static int findPatternCount(String word, String pattern)
	{
		int count = 0;
		int lastIndex = word.indexOf(pattern,0);
		while(lastIndex > -1)
		{
			count++;			
			lastIndex += pattern.length();
			lastIndex = word.indexOf(pattern, lastIndex);			
		}
		return count;
	}
	public static void main(String a[])
	{
		String s = "Hello Kannan Hello hi akan Kann Hello";
		System.out.println(findPatternCount(s, "Kan"));
	}
}
