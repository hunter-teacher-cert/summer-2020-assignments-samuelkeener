import java.io.*;
import java.util.*;

public class LList {
	private Node head;
	private int length;

	public LList() {
		head = null;
	}

	// Add a new Node containing value to the front of the list
	public void addFront(String value) {
		Node add = new Node(value);
		add.setNext(head);
		head = add;
		length++; // adjusts length of list
	}

	// Returns true if list is empty, false otherwise
	public boolean isEmpty() {
		return head == null; // If head is null, then the whole list is null
	}

	// Returns the value at index
	public String get(int index) {
		Node tmp = head;
		if (head == null) // prevents error if list is empty
			return null;
		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
			if (tmp == null) // returns null if index invalid
				return null;
		}
		return tmp.getData();
	}

	// Sets value of Node at index to value
	public void set(int index, String value) {
		Node tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
			if (tmp == null) // does nothing if index is invalid
				return;
		}
		tmp.setData(value);
	}

	// Inserts Node with given value at index, pushes remaining forward
	public void insert(int index, String value) {
		if (index == 0)
			addFront(value); // adds Node to front if index is 0
		else {
			Node tmp = head;
			for (int i = 0; i < index - 1; i++) { // stops just before index so it can push the value at the given index
													// forward
				tmp = tmp.getNext();
				if (tmp == null) // ends method if index invalid
					return;
			}
			Node tmp2 = tmp.getNext(); // stores next Node in tmp variable
			tmp.setNext(new Node(value, tmp2)); // creates new node after current index and sets its next value to tmp2
		}
		length++; // adjusts length of list
	}

	// Inserts given Node at index, pushes remaining forward
	public void insert(Node node, int index) {
		if (index == 0)
			addFront(node.getData()); // adds Node to front if index is 0
		else {
			Node tmp = head;
			for (int i = 0; i < index - 1; i++) { // stops just before index so it can push the value at the given index
													// forward
				tmp = tmp.getNext();
				if (tmp == null) // ends method if index invalid
					return;
			}
			node.setNext(tmp.getNext()); // attaches node to Node at target index
			tmp.setNext(node); // attaches tmp to node
		}
		length++; // adjusts length of list
	}

	// Finds index of key in List
	public int search(String key) {
		Node tmp = head;
		for (int i = 0;; i++) { // Loops goes until it is stopped by a return statement
			if (tmp.getData().equals(key)) // if data is equal to key, return i (index)
				return i;
			tmp = tmp.getNext();
			if (tmp == null) // we've reached the end of the list and didn't find it, return -1
				return -1;
		}
	}

	// Removes the Node at index
	public void remove(int index) {
		if (index == 0) { // removes first element by making the second element the new head
			head = head.getNext();
		} else {
			Node tmp = head;
			for (int i = 0; i < index - 1; i++) { // loops up until just before given index
				tmp = tmp.getNext();
				if (tmp == null)
					return;
			}
			Node tmp2 = tmp.getNext(); // creates reference to Node AFTER target index
			tmp.setNext(tmp2.getNext()); // sets next of Node before target to the node AFTER target, thus removing
		}
		length--; // adjusts length of list
	}

	// returns length value
	public int length() {
		if (head == null)
			return 0;
		else {
			Node tmp = head;
			for (int i = 1;; i++) {
				tmp = tmp.getNext();
				if (tmp == null)
					return i;
			}
		}
	}

	public String toString() {
		String s = "< "; // opening fencepost

		Node tmp;
		tmp = head;
		while (tmp != null) {
			s += tmp.getData() + " ";
			tmp = tmp.getNext();
		}

		s = s + ">"; // closing fencepost
		return s;
	}

}
