import java.io.*;
import java.util.*;

public class Loops {
	public static void main(String[] args){
		for (double i = 0.1; i <= 100; i*=10) {
			System.out.println(check(i));
		}
		/*It gets less accurate the larger the value of i.  After many attempts, there was no number of terms that made the estimate and the actual answer match exactly, onle to about 9 places after the decimal, which was when n was 12.
		*/
		for (double i = -0.1; i >= -100; i*=10) {
			System.out.println(check(i));
		}
		/*Similarly, the estimate gets less accurate the further i gets from 0.  */
	}

	//exercise 3
	public static double power(double x, int n) {
		double power = x;
		for (int i = 1; i < n; i++) {
			power*=x;
		}
		return power;
	}
	
	//exercise 4
	public static int factorial(int x) {
		int factorial = x;
		for (int i = x-1; i > 1; i--) {
			factorial*=x;
		}
		return factorial;
	}
	
	//exercise 5
	public static double myexp(double x, int n) {
		double myexp = 1;
		double num = 1;
		int den = 1;
		for (int i = 1; i <= n; i++) {
			den*=i;
			num*=x;
			myexp+=(num/den);			
		}
		return myexp;
	}
	
	public static String check(double x) {
		return x + "\t" + myexp(x,11) + "\t" + Math.exp(x);
	}
}
	
		
		