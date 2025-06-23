package week3.day1;

public class OnePlus extends AndroidTV{
	/*
	 * @Override public void openApp(){
	 * System.out.println("OpenApp method implementation from OnePlus."); }
	 */

	@Override
	public void playVideo() {
		System.out.println("playVideo method implementation.");
	}

	public static void main(String[] args) {

		OnePlus oneplusObj = new OnePlus();
		System.out.println("OnePlus Class");

		oneplusObj.openApp();
		oneplusObj.playVideo();

	}

}
