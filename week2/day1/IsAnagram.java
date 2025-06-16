package week2.day1;
import java.util.Arrays;
public class IsAnagram {
	public static void main(String[] args) {
		String input1="posts";
		String input2="stops";
		if (input1.length() == input2.length())
        {
			char[] str1=input1.toCharArray();
			char[]str2=input2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			if (Arrays.equals(str1, str2))
			{
				System.out.println("The given strings are Anagram");
			}
			else {
				System.out.println("The given strings are not Anagram");
			}
		}
		else {
			System.out.println("The given strings are not Anagram");
		}
}

	}


