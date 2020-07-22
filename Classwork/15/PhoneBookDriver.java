public class PhoneBookDriver {
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		System.out.println("Testing add() and printList():");
		book.add(new Person("Keener","Samuel","8608172985"));
		book.add(new Person("Smith","Jonnu","34984504"));
		book.add(new Person("Smith","Gary","3489305"));
		book.printList();
		System.out.println("Testing find() and reverseLookup()");
		System.out.println(book.find("Smith"));
		System.out.println(book.reverseLookUp("8608172985"));
		System.out.println("\nTesting remove:");
		Person sarah = new Person("Sarah","Lacina","343434343");
		book.add(new Person("Brady","Tom","7777777"));
		book.add(sarah);
		book.printList();
		book.remove(sarah);
		book.printList();
		
		
		
		

	} // end main
}// end class