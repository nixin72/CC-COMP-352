package a4_40082638_40042586;

import org.junit.*;

public class MyHashTable_Test {
//	@org.junit.Test
	public void Test_Element() {
		class Test {			
			public void testHashCode() {
				
			}
		}
		
		Test test = new Test();
		test.testHashCode();
	}
	
	@org.junit.Test
	public void Test_SeperateChaining() {
		class Test {
			MyHashTable mht;
			
			public void testPut() {
				mht = new MyHashTable_SeperateChaining(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = mht.put(0, "test");
				assertEq(expected, actual, "Separate Chaining: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(0, "test");
				actual = mht.put(0, "override element");
				assertEq(expected, actual, "Separate Chaining: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = mht.put(1, "new elment");
				assertEq(expected, actual, "Separate Chaining: Add a second element to the hash table.");
				
				expected = null;
				actual = mht.put(2, "another new element");
				assertEq(expected, actual, "Separate Chaining: add another element to the hash table.");
				
				expected = new Element(2, "another new element");
				actual = mht.put(2, "Overriding key 2");
				assertEq(expected, actual, "Separate Chaining: overriding the key 2 in the hash table.");
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = mht.get(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.get(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.get(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					actual = mht.get(3);
					expected = null;
					assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				}
				catch (NullPointerException e) {
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
				Element actual = mht.remove(0);
				assertEq(expected, actual, "Separate Chaining: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.remove(1);
				assertEq(expected, actual, "Separate Chaining: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.remove(2);
				assertEq(expected, actual, "Separate Chaining: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = mht.remove(3);
					expected = null;
					assertEq(expected, actual, "Separate Chaining: removing the third element in the hash table.");
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
				assertEq(size, mht.getSize(), "Separate Chaining: Size check after each operation.");
				assertEq(isEmpty, mht.isEmpty(), "Separate Chaining: empty check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	@org.junit.Test
	public void Test_LinearProbing() {
		class Test {	
			MyHashTable_LinearProbing mht;
			
			public void testPut() {
				mht = new MyHashTable_LinearProbing(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = mht.put(0, "test");
				assertEq(expected, actual, "Test_LinearProbing: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(0, "test");
				actual = mht.put(0, "override element");
				assertEq(expected, actual, "Test_LinearProbing: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = mht.put(1, "new elment");
				assertEq(expected, actual, "Test_LinearProbing: Add a second element to the hash table.");
				testSizeChecks(2, false, false);
				
				expected = null;
				actual = mht.put(2, "another new element");
				assertEq(expected, actual, "Test_LinearProbing: add another element to the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(2, "another new element");
				actual = mht.put(2, "Overriding key 2");
				assertEq(expected, actual, "Test_LinearProbing: overriding the key 2 in the hash table.");
				testSizeChecks(3, false, false);
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = mht.get(0);
				assertEq(expected, actual, "Test_LinearProbing: getting the first element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.get(1);
				assertEq(expected, actual, "Test_LinearProbing: getting the second element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.get(2);
				assertEq(expected, actual, "Test_LinearProbing: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					expected = null;
					actual = mht.get(3);
					assertEq(expected, actual, "Test_LinearProbing: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Test_LinearProbing: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(3, false, false);
				}
			}
			
			public void testRemove() {
				Element expected = new Element(0, "override element");
				Element actual = mht.remove(0);
				assertEq(expected, actual, "Test_LinearProbing: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.remove(1);
				assertEq(expected, actual, "Test_LinearProbing: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.remove(2);
				assertEq(expected, actual, "Test_LinearProbing: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = mht.remove(3);
					expected = null;
					assertEq(expected, actual, "Test_LinearProbing: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Test_LinearProbing: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(0, true, false);
				}
			}
			
			public void testSizeChecks(int size, boolean isEmpty, boolean isFull) {
				assertEq(size, mht.getSize(), "Test_LinearProbing: Size check after each operation.");
				assertEq(isEmpty, mht.isEmpty(), "Test_LinearProbing: empty check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	@org.junit.Test
	public void Test_QuadraticProbing() {
		class Test {			
			MyHashTable_QuadradicProbing mht;
			
			public void testPut() {
				mht = new MyHashTable_QuadradicProbing(10);
				testSizeChecks(0, true, false);
				
				Element expected = null;
				Element actual = mht.put(0, "test");
				assertEq(expected, actual, "Test_QuadraticProbing: Put first element into hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(0, "test");
				actual = mht.put(0, "override element");
				assertEq(expected, actual, "Test_QuadraticProbing: Override first element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = null;
				actual = mht.put(1, "new elment");
				assertEq(expected, actual, "Test_QuadraticProbing: Add a second element to the hash table.");
				
				expected = null;
				actual = mht.put(2, "another new element");
				assertEq(expected, actual, "Test_QuadraticProbing: add another element to the hash table.");
				
				expected = new Element(2, "another new element");;
				actual = mht.put(2, "Overriding key 2");
				assertEq(expected, actual, "Test_QuadraticProbing: overriding the key 2 in the hash table.");
			}
			
			public void testGet() {
				Element expected = new Element(0, "override element");
				Element actual = mht.get(0);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the first element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.get(1);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the second element in the hash table.");
				testSizeChecks(3, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.get(2);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the third element in the hash table.");
				testSizeChecks(3, false, false);
				
				try {
					actual = mht.get(3);
					expected = null;
					assertEq(expected, actual, "Test_QuadraticProbing: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
							new Element(-1, "IndexOutOfBoundsException"), 
							new Element(-1, "IndexOutOfBoundsException"), 
							"Test_QuadraticProbing: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(3, false, false);
				}
			}
			
			public void testRemove() {
				Element expected = new Element(0, "override element");
				Element actual = mht.remove(0);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the first element in the hash table.");
				testSizeChecks(2, false, false);
				
				expected = new Element(1, "new elment");
				actual = mht.remove(1);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the second element in the hash table.");
				testSizeChecks(1, false, false);
				
				expected = new Element(2, "Overriding key 2");
				actual = mht.remove(2);
				assertEq(expected, actual, "Test_QuadraticProbing: getting the third element in the hash table.");
				testSizeChecks(0, true, false);
				
				try {
					actual = mht.remove(3);
					expected = null;
					assertEq(expected, actual, "Test_QuadraticProbing: getting the third element in the hash table.");
				}
				catch (IndexOutOfBoundsException e) {
					assertEq(
						new Element(-1, "IndexOutOfBoundsException"), 
						new Element(-1, "IndexOutOfBoundsException"), 
						"Test_QuadraticProbing: getting the third element in the hash table."
					);
				}
				finally {
					testSizeChecks(0, true, false);
				}
			}
			
			public void testSizeChecks(int size, boolean isEmpty, boolean isFull) {
				assertEq(size, mht.getSize(), "Test_QuadraticProbing: Size check after each operation.");
				assertEq(isEmpty, mht.isEmpty(), "Test_QuadraticProbing: empty check after each operation.");
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
	}
	
	public void assertEq(Element expected, Element actual, String message) {
		if (actual != null && expected == null) {
			Assert.fail(message + "\nActual: " + actual.toString() + "\nExpected: " + expected);
		}
		else if (actual == null && expected != null) {
			Assert.fail(message + "\nActual: " + actual + "\nExpected: " + expected.toString());
		}
		else if (actual == null && expected == null) {
			//When this is the expected case, don't do anything.
		}
		else if (!actual.equals(expected)) {
			Assert.fail(message + "\nActual: " + actual.toString() + "\nExpected: " + expected.toString());
		}
	}
	
	public void assertEq(int expected, int actual, String message) {
		if (actual != expected) {
			Assert.fail(message + "\nActual: " + actual + "\nExpected: " + expected);
		}
	}
	
	public void assertEq(boolean expected, boolean actual, String message) {
		if (actual != expected) {
			Assert.fail(message + "\nActual: " + actual + "\nExpected: " + expected);
		}
	}
}