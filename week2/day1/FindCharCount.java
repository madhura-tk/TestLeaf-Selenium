package week2.day1;

public class FindCharCount {
	public static void main(String[] args) {
		String str ="Testleaf";
		char[] strArr=str.toCharArray();
		char c='e';
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			
			if(strArr[i]==c) {
				count++;
				
			}
		}
		System.out.println("The Character '"+c+"' appears "+count+" times in '"+str+"'.");

	}

}
