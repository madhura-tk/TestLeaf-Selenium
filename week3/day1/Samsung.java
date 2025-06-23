package week3.day1;

public class Samsung extends AndroidTV {

	/*
	 * @Override public void openApp(){
	 * System.out.println("OpenApp method implementation from Samsung."); }
	 */

	@Override
	public void playVideo() {
		System.out.println("playVideo method implementation.");
	}

	public static void main(String[] args) {

		Samsung samObj = new Samsung();
		System.out.println("Samsung Class");
		samObj.openApp();
		samObj.playVideo();

	}
	
	
}
