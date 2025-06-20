package week2.day4.homeAssignments.inheritance;

public class RadioButton extends Button{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadioButton r = new RadioButton();
		r.clickRadioButton();

	}
	public void clickRadioButton() {
		System.out.println("clickRadioButton() method is invoked");
		super.submit();
		
		
	}

}
