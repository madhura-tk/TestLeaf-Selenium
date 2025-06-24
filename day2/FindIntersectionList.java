package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersectionList {
	public static void main(String[] args) {

		Integer[] arr1 = { 3,2, 11, 4, 6, 7 };
		Integer[] arr2 = { 1, 2, 8, 4, 9, 7 };

		List<Integer> arrList1 = new ArrayList<>(Arrays.asList(arr1));
		List<Integer> arrList2 = new ArrayList<>(Arrays.asList(arr2));

		for (int i = 0; i < arrList1.size(); i++) {
			int num = arrList1.get(i);
			
			if (arrList2.contains(num)) {
				System.out.println(num);
			}
		}

	}

}
