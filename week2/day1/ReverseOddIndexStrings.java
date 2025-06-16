package week2.day1;

public class ReverseOddIndexStrings {
	public static void main(String[] args) {
		String test = "I am a software tester."; 
		String[] testArr=test.split(" ");
		for(int i=0;i<testArr.length;i++) {
			if(i%2 != 0) {
				String str="";
				char[]charArr=testArr[i].toCharArray();
				for(int j=charArr.length-1;j>=0;j--) {
					str+=charArr[j];
				}
				testArr[i]=str;
			}
			System.out.print(testArr[i]+" ");
	
		}

	}

}
