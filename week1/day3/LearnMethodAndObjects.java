package week1.day3;

public class LearnMethodAndObjects {
	
	int addNum() {
		
		int a=3,b=8,c;
		c=a+b;
		return c;
		
	}

	public static void main(String[] args) {
		LearnMethodAndObjects l=new LearnMethodAndObjects();
		int d =l.addNum();
		System.out.println(d);
	}
}
