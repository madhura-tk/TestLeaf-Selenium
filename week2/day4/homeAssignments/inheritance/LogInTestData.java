package week2.day4.homeAssignments.inheritance;

public class LogInTestData extends TestData{
	public static void main(String[] args) {
		LogInTestData login = new LogInTestData();
		login.enterUserName();
		login.enterUserPassword();
		login.navigateToHome();
		
		
		// TODO Auto-generated method stub

	}
	public void enterUserName()
	{
		System.out.println("EnterUserName ");
		super.enterCredentials();
	}
	
	public void enterUserPassword()
	{
		System.out.println("enterUserPassword ");
		super.enterCredentials();

	}


}
