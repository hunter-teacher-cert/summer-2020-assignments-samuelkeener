import java.io.*;
import java.util.*;

public class Arrays {
	public static void main(String[] args){
	}
	
	
	//Exercise 1-1
	public static double[] powArray(double[] a,  int x) {
		double[] powArray = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			powArray[i] = Math.pow(a[i], x);
		}
		return powArray;
	}
	
	//Exercise 1-2
	public static int[] histogram(int[] scores, int counters) {
		int[] histogram = new int[100];
		for (int i = 0; i < counters; i++) {
			histogram[scores[i]]++;
		}
		return histogram;
	}
	
	//Exercise 4
	public static int indexOfMax(int[] a) {
		int maxIndex = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[maxIndex]) maxIndex = i;
		}
		return maxIndex;
	}
		/*This task really wouldn't be compatible with the enhanced for loop, as it is necessary to reference previous elements and also keep track of the index we are on.  Both of those things are much more easily done in a standard for loop.*/
		
	//Exercise 5
	public static boolean[] sieve(int n) {
		boolean[] sieve = new boolean[n];
		for (int i = 0; i < n; i++) {
			sieve[i] = isPrime(i);
		}
		return sieve;
	}
	public static boolean isPrime(int number) {
		if (number <=2 ) return true;
		for (int i = 2; i < number/2; i++) {
			if (number%i==0) return false;
		}
		return true;
	}
}