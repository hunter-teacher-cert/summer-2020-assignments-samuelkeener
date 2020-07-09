import java.io.*;
import java.util.*;


public class ExceptionDriver {
	public static void main(String[] args) {
		LList g = new LList();
		
		try {
			g.addFront(null);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Element not added.");
		}
		
		try {
			g.addFront(null);
			g.addFront("everyone!");
			g.addFront("news!");
			g.addFront("good!");
		}
		catch (Exception e) {
			System.out.println("Element not added.");
		}
		
		System.out.println(g);
		LList h = new LList();
		
		try {
			h.remove(0);		
			g.remove(5);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Index out of bounds");
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Empty LinkedList");
		}
		
		System.out.println(g);
		
		
	} // end main
} // end class