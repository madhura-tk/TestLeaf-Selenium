package week2.day4.homeAssignments.inheritance;

public class Button extends WebElement{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button b = new Button();
		b.click();
		b.submit();
	}
	
	public void submit() {
		System.out.println("submit() method is invoked");
		super.setText("Button");
		
		
	}


}
