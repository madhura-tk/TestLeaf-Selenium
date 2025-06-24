package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingCollection {
	public static void main(String[] args) {
		String[] strArr = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		List<String> strList = new ArrayList<String>(Arrays.asList(strArr));
		Collections.sort(strList, Collections.reverseOrder());
		for (String str:strList) {
			System.out.println(str);
		}
	}
}
