package week2.day4.classActivity;

public class Safari extends Chrome{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Safari s = new Safari();
		s.clearCookies();
		s.closeBrowser("Safari");
		s.fullScreenMode();
		s.clearCache();
		
		
	}
	
	public void readMode() {
		System.out.println("readMode Method is called from Safari");
		
	}
	
	public void fullScreenMode() {
		System.out.println("fullScreenMode Method is called from Safari");
		
	}


}
