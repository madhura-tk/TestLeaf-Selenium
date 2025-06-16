package week2.day1.classActivity;

public class ReverseString {
public static void main(String[] args) {
	String companyName="TestLeaf";
	String reversedName="";
	for(int i=companyName.length()-1;i>=0;i--) {
		reversedName+=companyName.charAt(i);

	}
	System.out.println(reversedName);

}
}
