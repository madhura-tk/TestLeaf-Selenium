package week2.day1;

public class ReverseString {

	public static void main(String[] args) {
		String input="Amazon development centre Chennai"; 
		input=input.replace(","," ");
		String[] inputArr=input.split(" ");
		//System.out.print(inputArr[1]);
		for (int i=inputArr.length-1;i>=0;i--) {
			System.out.print(inputArr[i]+" ");
		}
		

	}
}
