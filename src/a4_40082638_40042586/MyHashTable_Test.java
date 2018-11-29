package a4_40082638_40042586;

import static org.junit.Assert.*;

public class MyHashTable_Test {
	@org.junit.Test
	public static void Test_Element() {
		class Test {			
			public void testHashCode() {
				
			}
		}
		
		Test test = new Test();
		test.testHashCode();
	}
	
	@org.junit.Test
	public static void Test_SeperateChaining() {
		class Test {
			MyHashTable sc;
			
			public void testPut() {				
				sc = new MyHashTable_SeperateChaining(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = sc.put(0, "test");
				assertEq(expected, actual, "Separate Chaining: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = actual;
				actual = sc.put(0, "override element");
				assertEq(expected, actual, "Separate Chaining: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = sc.put(1, "new elment");
				assertEq(expected, actual, "Separate Chaining: Add a second element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "another new element");
				assertEq(expected, actual, "Separate Chaining: add another element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "Overriding key 2");
				assertEq(expected, actual, "Separate Chaining: overriding the key 2 in the hash table.");
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = sc.get(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.get(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.get(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					actual = sc.get(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(3, false, false);
				}
			}
			
			public void testRemove() {
				Element expected = new Element(0, "override element");
				Element actual = sc.remove(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.remove(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.remove(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = sc.remove(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(0, true, false);
				}
			}
			
			public void testSizeChecks(int size, boolean isEmpty, boolean isFull) {
				assertEq(size, sc.size(), "Separate Chaining: Size check after each operation.");
				assertEq(isEmpty, sc.isEmpty(), "Separate Chaining: empty check after each operation.");
				assertEq(isFull, sc.isFull(), "Separate Chaining: full check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	@org.junit.Test
	public static void Test_LinearProbing() {
		class Test {	
			MyHashTable sc;
			
			public void testPut() {				
				sc = new MyHashTable_LinearProbing(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = sc.put(0, "test");
				assertEq(expected, actual, "Separate Chaining: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = actual;
				actual = sc.put(0, "override element");
				assertEq(expected, actual, "Separate Chaining: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = sc.put(1, "new elment");
				assertEq(expected, actual, "Separate Chaining: Add a second element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "another new element");
				assertEq(expected, actual, "Separate Chaining: add another element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "Overriding key 2");
				assertEq(expected, actual, "Separate Chaining: overriding the key 2 in the hash table.");
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = sc.get(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.get(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.get(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					actual = sc.get(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(3, false, false);
				}
			}
			
			public void testRemove() {
				Element expected = new Element(0, "override element");
				Element actual = sc.remove(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.remove(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.remove(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = sc.remove(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(0, true, false);
				}
			}
			
			public void testSizeChecks(int size, boolean isEmpty, boolean isFull) {
				assertEq(size, sc.size(), "Separate Chaining: Size check after each operation.");
				assertEq(isEmpty, sc.isEmpty(), "Separate Chaining: empty check after each operation.");
				assertEq(isFull, sc.isFull(), "Separate Chaining: full check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	@org.junit.Test
	public static void Test_QuadraticProbing() {
		class Test {			
			MyHashTable sc;
			
			public void testPut() {				
				sc = new MyHashTable_QuadradicProbing(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = sc.put(0, "test");
				assertEq(expected, actual, "Separate Chaining: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = actual;
				actual = sc.put(0, "override element");
				assertEq(expected, actual, "Separate Chaining: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = sc.put(1, "new elment");
				assertEq(expected, actual, "Separate Chaining: Add a second element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "another new element");
				assertEq(expected, actual, "Separate Chaining: add another element to the hash table.");
				
				expected = null;
				actual = sc.put(2, "Overriding key 2");
				assertEq(expected, actual, "Separate Chaining: overriding the key 2 in the hash table.");
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = sc.get(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.get(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.get(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					actual = sc.get(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(3, false, false);
				}
			}
			
			public void testRemove() {
				Element expected = new Element(0, "override element");
				Element actual = sc.remove(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = sc.remove(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = sc.remove(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = sc.remove(3);
					expected = new Element(3, "Overriding key 2");
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Separate Chaining: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(0, true, false);
				}
			}
			
			public void testSizeChecks(int size, boolean isEmpty, boolean isFull) {
				assertEq(size, sc.size(), "Separate Chaining: Size check after each operation.");
				assertEq(isEmpty, sc.isEmpty(), "Separate Chaining: empty check after each operation.");
				assertEq(isFull, sc.isFull(), "Separate Chaining: full check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	public static void assertEq(Element actual, Element expected, String message) {
		if (actual != null && expected == null) {
			System.out.println(message + "\nActual: " + actual.toString() + "\nExpected: " + expected);
		}
		else if (actual == null && expected != null) {
			System.out.println(message + "\nActual: " + actual + "\nExpected: " + expected.toString());
		}
		else if (!actual.equals(expected)) {
			System.out.println(message + "\nActual: " + actual.toString() + "\nExpected: " + expected.toString());
		}
	}
	
	public static void assertEq(int actual, int expected, String message) {
		if (actual != expected) {
			System.out.println(message + "\nActual: " + actual + "\nExpected: " + expected);
		}
	}
	
	public static void assertEq(boolean actual, boolean expected, String message) {
		if (actual != expected) {
			System.out.println(message + "\nActual: " + actual + "\nExpected: " + expected);
		}
	}
}