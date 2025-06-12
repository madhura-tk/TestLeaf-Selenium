package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rangeNumber=8;
		int a=0;
		int b=1;
		int sum=0;
		System.out.print("The Fibonacci Series of "+rangeNumber+" - ");
		for(int i=0;i<rangeNumber;i++) {
			if(i<rangeNumber-1) {
			System.out.print(sum+" , ");
			}
			else {
				System.out.print(sum);

			}
			sum=a+b;
			b=a;
			a=sum;
					
			}
		}

	}


