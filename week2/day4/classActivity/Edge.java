package week2.day4.classActivity;

public class Edge extends Browser{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Edge e= new Edge();
		e.closeBrowser("Edge");
		e.clearCookies();
		e.navigateBack("Edge");
	}
	
	public void takeSnap() {
		System.out.println("takeSnap Method is called from Edge");
		
	}
	
	public void clearCookies() {
		System.out.println("clearCookies Method is called from Edge");
		
	}


}
