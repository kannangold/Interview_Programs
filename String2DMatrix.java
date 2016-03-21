package string.sample;


public class String2DMatrix {
	
	/*Save the string “WELCOMETOERICSSONCORPORATION” in a two dimensional array and search for substring like “too” in the two dimensional string both from left to right and from top to bottom.

	w	e	L	C	O
	M	E	T	O	Z
	O	H	O	C	O
	R	P	O	R	A
	T	I	O	n	  

	And print the start and ending index as

	Start index : <1,2>

	End index: <3, 2>*/
	static int row,col;
	public static void main(String a[])
	{
		findPatternIn2DMatrix("WELCOMETOERICSSONCORPORATION","RNR");
	}
	public static void findPatternIn2DMatrix(String str, String pattern)
	{
		System.out.println("Length : " + str.length());
		double rowD = Math.sqrt(str.length());
		row =  (int)(rowD > Math.round(rowD) ? (rowD + 1) : rowD);
		System.out.println("Length : " + row);
		col = row;
		char[][] data = new char[row][col];
		int i = 0;
		for(int r=0; r < row;r++)
		{
			for(int c=0;c < col;c++)
			{
				if( i < str.length())
				{
					data[r][c] = str.charAt(i);
					i++;
				}
				else
					break;
			}
		}
		for(int r=0; r < row;r++)
		{
			for(int c=0;c < col;c++)
			{
				System.out.print(data[r][c] + " ");
			}
			System.out.println("");
		}
		
		for(int r=0;r<row;r++)
		{
			//System.out.println("Start" + row + col);
			//for(int c=0;c<(col-pattern.length());c++)
			for(int c=0;c<col;c++)
			{
				String result = findLeftToRight(data, r, c, pattern);
				System.out.println("r=" + r + "c=" + c + " Result=" + result);
				if(result.equals(pattern))
					System.out.println("Start Index = " + r + ", " + c + " End Index = " + r + ", " + (c + pattern.length()));
				result = findTopToBottom(data, r, c, pattern);
				System.out.println("r=" + r + "c=" + c + " Result=" + result);
				if(result.equals(pattern))
					System.out.println("Start Index = " + r + ", " + c + " End Index = " + (r + pattern.length()) + ", " + c);
				System.out.println("r= " + r + " c= "+ c + "row=" + row + " col=" + col);
			}
			//System.out.println("Over");
		}
	}
	public static String findLeftToRight(char[][] data,int r, int c, String pattern)
	{
		int l=0;
		String str="";
		while(l < pattern.length())
		{
			if(r < row && (c+l) < col)
			{
				str += data[r][(c+l)];
				l++;
			}
		}
		return str;
	}
	public static String findTopToBottom(char[][] data,int r, int c, String pattern)
	{
		int l=0;
		String str="";
		while(l < pattern.length())
		{
			if((r+l) < row && c < col)
			{
				str += data[(r+l)][c];
				l++;
			}
		}
		return str;
	}
}
