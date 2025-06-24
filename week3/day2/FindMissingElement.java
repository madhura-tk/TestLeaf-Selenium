package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingElement {
	public static void main(String[] args) {
		Integer arrInt[] = { 1, 10, 6, 4, 3 };
		List<Integer> arrList = new ArrayList<>(Arrays.asList(arrInt));
		Collections.sort(arrList);
		System.out.println("The Missing Elements are :");

		for (int i = 0; i < arrList.size(); i++) {
			if (arrList.get(i) != i + 1) {
				arrList.add(i, i + 1);
				System.out.println(arrList.get(i));
			}
		}

	}

}
