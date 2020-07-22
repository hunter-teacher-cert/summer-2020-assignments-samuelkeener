import java.io.*;
import java.util.*;

public class Methods {
	public static void main(String[] args){
		System.out.println(isDivisible(6,3));
		System.out.println(isTriangle(1,2,4));
		System.out.println(ack(1,2));
		System.out.println(ack(2,1));
		System.out.println(ack(2,2));

	}
	
	//exercise 2
	public static boolean isDivisible(int n, int m) {
		return n%m==0;
	}

	//exercise 3
	public static boolean isTriangle(int a, int b, int c) {
		return !((a+b<c)||(a+c<b)||(b+c<a));
	}
		
	//exercise 8
	public static int ack(int m, int n) {
		if (m==0) return n+1;
		if (m>0&&n==0) return ack(m-1,1);
		if (m>0&&n>0) return ack(m-1,ack(m,n-1));
		return 0;
	}
}
		