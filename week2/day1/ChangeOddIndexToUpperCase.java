package week2.day1;

public class ChangeOddIndexToUpperCase {
	public static void main(String[] args) {
		String str="changeme";
		char[] charArr=str.toCharArray();
		for(int i=0;i<charArr.length;i++)
		{
			if(i%2!=0)
			{
				charArr[i]=Character.toUpperCase(charArr[i]);
			}
		}
		System.out.print(charArr);

	}

}
