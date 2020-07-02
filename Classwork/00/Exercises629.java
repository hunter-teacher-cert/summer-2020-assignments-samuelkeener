import java.util.Arrays;
import java.util.*;

public class Exercises629 {
	
public static void main(String[] args) {
	System.out.println("Hello World");
	System.out.println(factorial(6));
	System.out.println(fib(9));
	int[] array = {1,2,3,4,12};
	System.out.println(recursiveSum(array));
	
}

//Exercise 2
public static int factorial(int n) {
          if (n<=1)  return 1;
          return n*factorial(n-1);
}

//Exercise 3
public static int fib(int n) {
	if (n <= 2) return 1;
	return fib(n-1)+fib(n-2);
}

//Exercise 4 
/*
 * factorial(6) =
 * 	6*factorial(5) 
 * 		5*factorial(4)
 * 			4*factorial(3)
 * 				3*factorial(2)
 * 					2*factorial(1)
 * 						1	
 	
 *fib(9) = 		fib(8) 	   		+ 				fib(7) 
 *         fib(7)	+	fib(6)				fib(6)	+	fib(5)
 *     fib6  +  fib5    	=fib5 +  fib4      fib5+fib4
 *   fib5+fib4  fib4+fib3    f4 + f3   f3 + 1
 * fib4+fib3	f3+1  1+1    f3+1 1+1
 * f3+1  1+1   1+1           1+1
 *1+1
 *You get the idea...
 *
 *The biggest similarity between the two trace diagrams are the multiple layers of method calls
 *represented by different lines in the code.  You have to trace it backwards to get the final result.
 *
 *The biggest difference is that the fibonacci method has two recursive method calls, making its trace diagram
 *far more complicated, with each layer increasing in complexity as the program continues.
 */

//Exercise 5
public static int ack(int m, int n) {
	if (m==0) return n+1;
	if (m>0&&n==0) return ack(m-1,1);
	if (m>0&&n>0) return ack(m-1,ack(m,n-1));
	return 0;
}

//Exercise 6: Challenge problem
public static int recursiveSum(int[] ia) {
	if (ia.length==1) return ia[0];
	int[] next = Arrays.copyOf(ia,ia.length-1);
	return ia[ia.length-1]+recursiveSum(next);
}
}