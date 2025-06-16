package week2.day1;

public class RemoveDuplicateWords {
	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		//String text="Java java java";
		String[] textArr=text.split(" ");
		for(int i=0;i<textArr.length;i++)
		{
			int count=0;
			for (int j=0;j<textArr.length;j++) {
				if(textArr[i].equalsIgnoreCase(textArr[j])) {
					count+=1;
					if(count>1) {
					textArr[j]="";
					}
				}
			}
			System.out.print(textArr[i]+" ");
		}
	}
}
