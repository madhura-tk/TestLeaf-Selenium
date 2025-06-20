package week2.day4.classActivity;

public class Chrome extends Edge{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Chrome c =new Chrome();
		c.clearCache();
		c.clearCookies();
		c.openIncoginto();
		c.openURL("Chrome");
		c.closeBrowser("Chrome");
		c.takeSnap();
	}
	
	public void openIncoginto() {
		System.out.println("openIncoginto Method is called from Chrome");
		
	}
	
	public void clearCache() {
		System.out.println("clearCache Method is called from Chrome");
		
	}


}

