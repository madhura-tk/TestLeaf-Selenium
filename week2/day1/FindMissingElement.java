package week2.day1;

import java.util.Arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		int[] intArr= {1,4,3,2,8,6,7}; 
		Arrays.sort(intArr);
		int i =1;
		while(i<intArr.length){
			if(intArr[i-1]!=i) {
				System.out.println(i);
				break;
			}
			i+=1;
		}
	}

}
