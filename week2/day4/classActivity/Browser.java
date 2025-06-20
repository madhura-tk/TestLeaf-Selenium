package week2.day4.classActivity;

public class Browser {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browserName="Chrome";
		String browserVersion="137.0.7151.104";
		
	}
	
	public void openURL(String subclassname) {
		System.out.println("Browser:openUrl Method is called from subclass "+subclassname);
		
	}
	
	public void closeBrowser(String subclassname) {
		System.out.println("Browser:closeBrowser Method is called from subclass "+subclassname);
		
	}

	public void navigateBack(String subclassname) {
		System.out.println("Browser:openUrl Method is called from from subclass "+subclassname);
		
	}


}
