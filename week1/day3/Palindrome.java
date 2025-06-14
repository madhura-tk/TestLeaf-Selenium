package week1.day3;

public class Palindrome {
	public static void main(String[] args) {
		int input=121;
		int output=0;
		int i=input;
		int count=String.valueOf(input).length();
		while(count > 0) {	
			output=output+(int) ((i%10)* Math.pow(10,count-1));
			count-=1;
			i=i/10;
			
		}
		if (input == output) {
			System.out.println("The Input No : "+input+" is a Palindrome");
		}
		else {
			System.out.println("The Input No : "+input+" is not a Palindrome");
		}
	}

}
