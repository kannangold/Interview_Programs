package string.sample;

public class StringToXFormat {
	public static void printStringInXformat(String str) {
		int len = str.length() - 1;
		int i = 0, j = len;
		int startCtrl, endCtrl;
		while (i < str.length()) {
			if (i < j) {
				startCtrl = i;
				endCtrl = (j - (i + 1));
			} else {
				startCtrl = j;
				endCtrl = (i - (j + 1));
			}
			for (int k = 0; k < startCtrl; k++)
				System.out.print(" ");
			if (i != j && i < j) {
				System.out.print(str.charAt(i));
			} else {
				System.out.print(str.charAt(j));
			}
			for (int k = 0; k < endCtrl; k++)
				System.out.print(" ");
			if (i != j && i < j) {
				System.out.print(str.charAt(j));
			} else if (i != j) {
				System.out.print(str.charAt(i));
			}
			i++;
			j--;
			System.out.println("");
		}
	}
	public static void printXformat(String s)
	{
		int length = s.length();
        for (int i = 0; i < length; i++) {
        	if(length % 2 == 0 && i == length / 2)
        	{
        		continue;
        	}
            for (int j = 0; j < length; j++) {
                if (j == i || j == (length- 1 - i)) {
                    System.out.print(s.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		printStringInXformat("PROGRAMES");
		printXformat("PROGRAMES");
	}
}
