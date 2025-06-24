package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNo {
	public static void main(String[] args) {
		
		Integer [] arrInt = {3,2,11,4,6,7};
		List<Integer> listArr = new ArrayList<Integer>(Arrays.asList(arrInt));
		
		//Collections.sort(listArr);
		//Collections.reverse(listArr);
        Collections.sort(listArr, Collections.reverseOrder());

		System.out.println(listArr.get(1));

	}
	
	
}
