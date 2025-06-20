package week2.day4.homeAssignments.inheritance;

public class CheckBoxButton extends Button{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoxButton e = new CheckBoxButton();
		e.clickCheckButton();


	}
	public void clickCheckButton() {
		System.out.println("clickCheckButton() method is invoked");
		super.setText("CheckBoxButton");
		super.submit();
		
	}


}
