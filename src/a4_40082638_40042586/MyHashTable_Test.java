package a4_40082638_40042586;

public class MyHashTable_Test {

	public static void main(String[] args) {
		Test_Element();
		Test_SeperateChaining();
		Test_LinearProbing();
		Test_QuadraticProbing();
	}
	
	public static void Test_Element() {
		class Test {			
			public void testHashCode() {
				
			}
		}
		
		Test test = new Test();
		test.testHashCode();
	}
	
	public static void Test_SeperateChaining() {
		class Test {			
			public void testPut() {
				MyHashTable_SeperateChaining sc = new MyHashTable_SeperateChaining(10);
				Element expected = null;
				Element actual = sc.put(0, "test");
				
				assertEq(expected, actual, "Separate Chaining: Put first element into hash table.");
				
				expected = actual;
				actual = sc.put(0, "override element");
				assertEq(expected, actual, "Separate Chaining: Override first element in the hash table.");
				
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
				
			}
			
			public void testRemove() {
				
			}
			
			public void testSize() {
				
			}
			
			public void testIsEmpty() {
				
			}
			
			public void testIsFull() {
				
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
		test.testSize();
		test.testIsEmpty();
		test.testIsFull();
	}
	
	public static void Test_LinearProbing() {
		class Test {			
			public void testPut() {
				
			}
			
			public void testGet() {
				
			}
			
			public void testRemove() {
				
			}
			
			public void testSize() {
				
			}
			
			public void testIsEmpty() {
				
			}
			
			public void testIsFull() {
				
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
		test.testSize();
		test.testIsEmpty();
		test.testIsFull();
	}
	
	public static void Test_QuadraticProbing() {
		class Test {			
			public void testPut() {
				
			}
			
			public void testGet() {
				
			}
			
			public void testRemove() {
				
			}
			
			public void testSize() {
				
			}
			
			public void testIsEmpty() {
				
			}
			
			public void testIsFull() {
				
			}
		}
		
		Test test = new Test();
		test.testPut();
		test.testGet();
		test.testRemove();
		test.testSize();
		test.testIsEmpty();
		test.testIsFull();
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
}