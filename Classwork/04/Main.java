public class Main {
	public static void main(String[] args) {
		SuperArray array1 = new SuperArray();
		System.out.println(array1);
		System.out.println(array1.isEmpty());
		SuperArray array2 = new SuperArray(5);
		System.out.println(array2);
		for(int i = 1; i <= 8; i++) {
			array1.add(i);
			array2.add(i);
		}
		System.out.println(array1);
		System.out.println(array2);
		array1.remove(5);
		System.out.println(array1);
		array2.add(2,25);
		System.out.println(array2);
		
	}
} //end class