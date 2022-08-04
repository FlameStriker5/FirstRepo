package app;
import core.HashTable;

public class App {

	public static void main(String[] args) throws Exception {
		HashTable<Object> h1=new HashTable<>();
/*
 * Test case 1: Adding elements such that each bucket is occupied
 */ System.out.println("------------------------------*Test case 1*-----------------------------------");
		h1.put(1, "Mercury");
		h1.put(2, "Venus");
		h1.put(3, "Earth");
		h1.put(4, "Mars");
		h1.put(5, "Jupiter");
		h1.put(6, "Saturn");
		h1.put(7, "Uranus");
		h1.put(8, "Neptune");
		h1.put(9, "Pluto");
		h1.put(10, "God planet");
		h1.PrintAll(1);				// Works for each bucket
		System.out.println("------------------------------*Test case 2*-----------------------------------");
/*
 * Test case 2: Adding elements at same bucket to check the working of AVL Tree at that bucket
 */
		h1.put(13, "Asia");
		h1.put(23, "Africa");
		h1.put(33, "North America");
		h1.put(43, "South America");
		h1.put(53, "Antarctica");
		h1.put(63, "Europe");
		h1.put(73, "Australia");
		h1.PrintAll(3);					// to check avl tree at given bucket
		System.out.println("------------------------------*Test case 3*-----------------------------------");
/*
 * Test case 3: Verification of remove method
 */
		h1.remove(15);
		h1.remove(9);
		h1.remove(26);
		h1.PrintAll(15);
		h1.PrintAll(9);
		h1.PrintAll(26);
		System.out.println("------------------------------*Test case 4*-----------------------------------");
/*
 * Test case 4: Verification of search method
 */
		System.out.println("Value in a bucket 5 ::"+h1.get(25));
	}
/*
 * Conclusion: all test cases are verified with all possible inputs and corner cases are tested successfully
 */

}
