
package a4_40082638_40042586;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Class Name: MyHashTable_LinearProbing
 * Extends: __MyHashTable__
 * 
 * - probingattempts : int
 * - elements[] ArrayList<Element>
 * 
 * <<constructor>> + MyHashTable_LinearProbing()
 * <<constructor>> + MyHashTable_LinearProbing(capacity : int)
 * # findElement(key : Integer) : Element
 * + resize(newcap : int) : void
 * + get(index : int) : Element
 * + put(key : int, value : String) : Element
 * + remove(key : int) : Element
 * # hasCollision(index : int) : boolean
 * # compress(hashcode : int) : int
 * + toString() : String
 * # printInfo(collision : int, probingattempt : int) : void
 * +* main(args[] : String) : void
 * 
 */
public class MyHashTable_LinearProbing extends MyHashTable {
	private int probingattempts = 0;
	private Element[] elements;
	
	public MyHashTable_LinearProbing() {
		super();
		elements = new Element[getCapacity()];
		setLoadFactor(0.5);
	}
	
	public MyHashTable_LinearProbing(int capacity) {
		super(capacity);
		elements = new Element[capacity];
		setLoadFactor(0.5);
	}
 
	/*
	 * Input: Integer
	 * 
	 * Purpose: 
	 * 	Find the element at the given index, handing the given type of probing used. 
	 * 
	 * Output: Element
	 * 
	 * */
	protected Element findElement(Integer key) {
        return elements[compress(new Element(key,"").hashCode())];
	}
	
	/*
	 * Input: int 
	 * 
	 * Purpose: 
	 * 	Resize the underlying array to be able to handle more elements. 
	 * 
	 * Output: Void
	 * */
	public void resize(int newcap) {
		Element[] temp = new Element[newcap];
		
		for(int i = 0; i<capacity;i++) {
			temp[i]=elements[i];
		}
		
		elements = new Element[newcap];
		
		for(int i = 0; i<newcap;i++) {
			if(temp[i]!=null) {
				put(temp[i].getKey(), temp[i].getValue());
			}
		}
		
		capacity = newcap;
	}

	/*
	 * Input: int
	 * 
	 * Purpose: 
	 * 	Public facing method to access the element with a certain key in the hash table.
	 * 
	 * Output: Element
	 * */
	@Override
	public Element get(int key) {
		long startTime = System.nanoTime();
		Element element = new Element(key, "");
        int hashCode = element.hashCode();
		try {
			if (elements[compress(hashCode)].getKey() != key) {
				throw new CollisionException();
			}
			else {
				element = new Element(elements[compress(hashCode)]);
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time in nanoseconds:"+totalTime);
				
				return element;
			}
		}
		catch (NullPointerException e) {
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Time in nanoseconds:"+totalTime);
			
			return null;
		}
		catch (CollisionException e) {
			while (hasCollision(compress(hashCode))) {
				if (elements[compress(hashCode)].getKey() == key) {
					element = new Element(elements[compress(hashCode)]);
					break;
				}
				probingattempts++;
				hashCode++;
			}
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time in nanoseconds:"+totalTime);
		
		return element;
	}
	
	/*
	 * Input: int, String
	 * 
	 * Purpose:
	 * 	Insert a key/value pair into the hash table, handing collisions using 
	 * 	the Quadratic probing method. 
	 * 
	 * Output: Element
	 * 
	 * */
	@Override
	public Element put(int key, String value) {
		long startTime = System.nanoTime();
		int collision = 0;
		int probes = 0;
		Element replaced = null;
		
		if ((double) size / capacity >= loadfactor) {
			resize(nextPrime(capacity * 2));
		}
        Element element = new Element(key, value);
        int hashCode = element.hashCode();
		try {
			if (elements[compress(hashCode)].getKey() != key) {
				throw new CollisionException();
			}
			else {
				replaced = new Element(key, findElement(key).getValue());
				elements[compress(hashCode)].setValue(value);
				elements[compress(hashCode)].setAvailable(false);
				
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time in nanoseconds:" + totalTime);
				printInfo(collision, probes);
				
				return replaced;
			}
		}
		catch (NullPointerException e) {
			elements[compress(hashCode)] = element;
			size++;
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Time in nanoseconds:"+totalTime);
			printInfo(collision, probes);
			
			return replaced;
		}
		catch (CollisionException e) {
			while (hasCollision(compress(hashCode))) {
				probes++;
				collision++;
				probingattempts++;
				hashCode++;
			}
		}
		
		size++;
		printInfo(collision,probes);
		elements[compress(hashCode)] = element;
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time in nanoseconds:"+totalTime);
		
		return replaced;
	}

	/*
	 * Input: int
	 * 
	 * Purpose:
	 * 	Remove the element with the given key from the hash table. 
	 * 	Uses quadratic probing to find the element to remove. 
	 * 
	 * Output: Element
	 * 
	 * */
	@Override
	public Element remove(int key) {
		long startTime = System.nanoTime();
		Element element = new Element(key,"");
        int hashCode = element.hashCode();
        
		try {
			if (elements[compress(hashCode)].getKey()!=key) {
				throw new CollisionException();
			}
			else {
				size--;
				element = new Element(elements[compress(hashCode)]);
				elements[compress(hashCode)].setValue(null);
				elements[compress(hashCode)].setKey(null);
				elements[compress(hashCode)].setAvailable(true);
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time in nanoseconds:"+totalTime);
				
				return element;
			}
		}
		catch (NullPointerException e) {
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Time in nanoseconds:"+totalTime);
			
			return null;
		}
		catch (CollisionException e) {
			while (hasCollision(compress(hashCode))) {
				if (elements[compress(hashCode)].getKey() == key) {
					element = new Element(elements[compress(hashCode)]);
					elements[compress(hashCode)].setKey(null);
					elements[compress(hashCode)].setValue(null);
					elements[compress(hashCode)].setAvailable(true);
					size--;
					break;
				}
				probingattempts++;
				hashCode++;
			}
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time in nanoseconds:"+totalTime);
		
		return element;
	}

	/*
	 * Input: int
	 * 
	 * Purpose:
	 * 	Determine if there's already an element at the given index in the 
	 * 	underlying array. 
	 *  
	 * Output: boolean
	 * 
	 * */
	@Override
	protected boolean hasCollision(int index) {
		try {
			return elements[index].available == false;
		}
		catch (NullPointerException e) {
			return false;
		}
	}
	
	/*
	 * Input: int
	 * 
	 * Purpose: 
	 * 	Convert the given hashcode into a smaller value within the indexes of the array.  
	 *  
	 * Output: int  
	 * 
	 * */
	@Override
	protected int compress(int hashcode) {
		return (hashcode & 0x7fffffff) % capacity;
	}
	
	/*
	 * Input: N/A
	 * 
	 * Purpose: 
	 * 	Return the string value of the contents of the array. 
	 * 
	 * Output: String
	 * 
	 * */
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
	
	protected void printInfo(int collision, int probingattempt) {
		System.out.println("Probing attempts for map: " + probingattempts);
		System.out.println("Size: " + size);
		System.out.println("Collisions: " + collision);
		System.out.println("Probing attempts for put: " + probingattempt);
	}

	/*
	 * Input: String[]
	 * 
	 * Purpose: 
	 * 	Run some basic tests on the methods in the class to make sure that the 
	 * 	hash table can be used properly.
	 * 
	 * Output: void
	 * 
	 * */
	public static void main(String[] args) {
		MyHashTable_LinearProbing map = new MyHashTable_LinearProbing(100);
		System.out.println(map.toString());
		ArrayList<Element> values = new ArrayList<Element>();
		
		for (int i = 0; i < 50; i++) {
			Element a = new Element("RANDOM");
			values.add(a);
		}
		
		System.out.println("PUTTING VALUES IN HASHMAP");
		
		for (int i = 0 ; i < 50 ; i++) {	
			System.out.println(map.put(values.get(i).getKey(),"JOB"+i));
		}
		
		System.out.println(map.toString());
		System.out.println("GETTING VALUES FROM HASHMAP");
		
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println(map.get(values.get(i).getKey()));
		}
		
		System.out.println(map.toString());
		System.out.println("REMOVING VALUES FROM HASHMAP");
		
		for (int i = 0 ; i < 25 ; i++) {
			System.out.println(map.remove(values.get(i).getKey()));
		}
		
		System.out.println(map.toString());
		System.out.println("GETTING VALUES FROM HASHMAP");
		
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println(map.get(values.get(i).getKey()));
		}
		
		System.out.println(map.toString());
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        
		int[] number = {50, 75, 75, 100, 150};
		
		for (int g = 0 ; g < 5 ; g++) {
			MyHashTable_LinearProbing map1 = new MyHashTable_LinearProbing(number[g]);
			System.out.println("PUTTING VALUES IN HASHMAP FOR VALUE: " + number[g]);
			
			for (int i = 0 ; i < 150 ; i++) {
				System.out.println(map1.put(new Element("").getKey(),""));
			}
			
			System.out.println(map1.toString());
		}
	}
}