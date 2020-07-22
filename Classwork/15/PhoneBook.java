import java.util.*;

public class PhoneBook {

	// We will use a Hash structure for this data set. The PhoneBook
	// will be represented by an Array of ArrayLists of Persons. We will
	// search the book using closed probing.

	private ArrayList<Person>[] theBook;

	public PhoneBook() {
		theBook = new ArrayList[599];
	}

	// adds a person to the phone book
	public void add(Person person) {
		// generates hash index based on last name
		int index = hashFunc(person.getLastName());
		if (theBook[index] == null) { // if this index is empty, create a new ArrayList
			theBook[index] = new ArrayList<Person>();
		}
		// add the Person to the ArrayList at given index
		theBook[index].add(person); // adds person to end of ArrayList at index

		// creates parallel hash structure to store index of phone numbers
		// for reverse lookup
		int phoneNumberIndex = hashFunc(person.getPhoneNumber());
		if (theBook[phoneNumberIndex] == null) {
			theBook[phoneNumberIndex] = new ArrayList<Person>();
		}
		theBook[phoneNumberIndex].add(person); // adds person to end of ArrayList at index
	}

	// returns a List of people with the given last Name
	public ArrayList<Person> find(String lastName) {
		ArrayList<Person> lastNames = new ArrayList();
		int index = hashFunc(lastName);
		// traverses ArrayList at given hash index of theBook looking for right Person
		for (Person p : theBook[index]) {
			// if the lastName matches, return that Person object
			if (p.getLastName().equals(lastName)) {
				lastNames.add(p);
			}
		}
		return lastNames;
	}

	// removes a person from the phonebook. Returns true if removed, false if not
	public void remove(Person person) {
		int index = hashFunc(person.getLastName());
		int phoneNumberIndex = hashFunc(person.getPhoneNumber());
		// traverses ArrayList at given hash index of theBook looking for right Person
		for (int i = 0; i < theBook[index].size(); i++) {
			// if object is equal, remove it, then break loop
			if (theBook[index].get(i).equals(person)) {
				theBook[index].remove(i);
				break;
			}
		}
		//must also remove entry sorted by phoneNumber
		for (int i = 0; i < theBook[phoneNumberIndex].size(); i++) {
			// if object is equal
			if (theBook[phoneNumberIndex].get(i).equals(person)) {
				theBook[phoneNumberIndex].remove(i);
				return;
			}
		}		
	}

	public Person reverseLookUp(String phoneNumber) {
		int index = hashFunc(phoneNumber);
		// traverses ArrayList at given hash index of theBook looking for right Person
		for (Person p : theBook[index]) {
			// if the lastName matches, return that Person object
			if (p.getPhoneNumber().equals(phoneNumber)) {
				return p;
			}
		}
		return null;
	}

	// Creates a hash index given a lastname
	private int hashFunc(String lastName) {
		int sum = 0;
		for (int i = 0; i < lastName.length(); i++) {
			sum += lastName.charAt(i);
		}
		return sum % 599;
	}

	// prints out the entire phone book
	public void printList() {
		String output = "";
		for (int i = 0; i < theBook.length; i++) {
			if (theBook[i] != null) {
				for (Person p : theBook[i]) {
					if (!output.contains(p.toString())) // skips repeats (see addition)
						output += p + "\n";
				}
			}
		}
		System.out.println(output);

	}

}// end class