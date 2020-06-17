import java.io.*;
import java.util.*;

public class Temperature {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a temperature in Celsius to convert to Fahrenheit: ");
		double celsius = input.nextDouble();
		double fahrenheit = celsius * (9.0/5) + 32;
		System.out.printf("%.1f C = %.1f F",celsius,fahrenheit);
	}
}