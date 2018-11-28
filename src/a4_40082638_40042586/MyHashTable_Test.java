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
}