package a4_40082638_40042586;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Class Name: MyHashTable_SeperateChaining
 * Extends: __MyHashTable__
 * 
 * - elements[] ArrayList<Element>
 * 
 * <<constructor>> + MyHashTable_SeperateChaining()
 * <<constructor>> + MyHashTable_SeperateChaining(capacity : int)
 * + resize(newcap : int) : void
 * + get(index : int) : Element
 * + put(key : int, value : String) : Element
 * + remove(key : int) : Element
 * # hasCollision(index : int) : boolean
 * # findElement(key : Integer) : Element
 * # compress(hashcode : int) : int
 * + toString() : String
 * +* main(args[] : String) : void
 * 
 */
public class MyHashTable_SeperateChaining extends MyHashTable {
	private ArrayList<Element> elements[];
	
	@SuppressWarnings("unchecked")
	public MyHashTable_SeperateChaining() {
		super();
		elements = (ArrayList<Element>[])new ArrayList[getCapacity()];
		setLoadFactor(0.5);
	}
	
	@SuppressWarnings("unchecked")
	public MyHashTable_SeperateChaining(int capacity) {
		super(capacity);
		elements = (ArrayList<Element>[])new ArrayList[capacity];
		setLoadFactor(0.5);
	}

	/*
	 * Input: int 
	 * 
	 * Purpose: 
	 * 	Resize the underlying array to be able to handle more elements. 
	 * 
	 * Output: Void
	 * */
	@SuppressWarnings("unchecked")
	public void resize(int newcap) {
		ArrayList<Element> newelem[] = (ArrayList<Element>[])new ArrayList[newcap];
		for (int i = 0 ; i < capacity ; i++) {
			newelem[i] = elements[i];
		}
		
		elements = newelem;
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
		return findElement(key);
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
		Instant start = Instant.now();
		Element element;
        int probez = 0;
        int hashCode;
        Element replaced = null;
        
		try {
			if (findElement(key).getKey() != key) {
				throw new CollisionException();
			}
			else {
				replaced = new Element(key, findElement(key).getValue());
				findElement(key).setValue(value);
				Instant end = Instant.now();
				Duration timeElapsed = Duration.between(start, end);
				System.out.println("capacity of the table:" + capacity);
				System.out.println("Size of the table:" + size);
				System.out.println("Probing attempts:" + probez);
				System.out.println("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
				
				return replaced;
			}
		}
		catch (CollisionException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			
			while (hasCollision(compress(hashCode))) {
				probez++;
				hashCode = (int) Math.pow(probez, 2);
			}
		}
		catch (NullPointerException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			try {
				elements[compress(hashCode)].add(element);
			}
			catch (NullPointerException err) {
				elements[compress(hashCode)] = new ArrayList<Element>();
				elements[compress(hashCode)].add(element);
			}
		}
		
		size++;
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		element = new Element(key,value);
		elements[compress(hashCode)].add(element);
		
		if ((double) size/capacity >= loadfactor) {
			resize(nextPrime(capacity*2));
		}
		
		System.out.println(start);
		System.out.println(end);
		System.out.println("capacity of the table:" + capacity);
		System.out.println("Size of the table:" + size);
		System.out.println("Probing attempts:" + probez);
		System.out.println("Time taken: " + timeElapsed.toNanos() + " nanoseconds");
		
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
		Instant start = Instant.now();
        Element element;
        int hashCode;
        int probez = 0;
        
		try {
			element = new Element(findElement(key));
			
			if (findElement(key).getKey() != key) {
				throw new CollisionException();
			}
			else {				
				findElement(key).setValue(null);
				findElement(key).setKey(null);
				findElement(key).setAvailable(true);
				size--;
				return element;
			}
		}
		catch (CollisionException e) {
			hashCode = new Element(key, null).hashCode();
			while (hasCollision(compress(hashCode))) {
				if (key == findElement(key).getKey()) {
					break;
				}
				probez++;
				hashCode = (int) Math.pow(probez, 2);
			}
		}
		catch (NullPointerException e) {
			return null;
		}
		
		
		try {
			element = new Element(findElement(key));
			findElement(key).setAvailable(true);
			findElement(key).setKey(null);
			findElement(key).setValue(null);
			size--;
		}
		catch (NullPointerException e) {
			return null;
		}          
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
		size--;
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
			return elements[index].get(0).available == false;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		catch (NullPointerException e) {
			return false;
		}
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
		ArrayList<Element> elems = elements[compress(new Element(key, "").hashCode())];
		Element output = null;
		for (Element elem : elems) {
			if (elem.getKey() == key) {
				output = elem;
			}
		}
		
		return output;
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
		MyHashTable_SeperateChaining map = new MyHashTable_SeperateChaining(100);
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
			MyHashTable_SeperateChaining map1 = new MyHashTable_SeperateChaining(number[g]);
			System.out.println("PUTTING VALUES IN HASHMAP FOR VALUE: " + number[g]);
			
			for (int i = 0 ; i < 150 ; i++) {
				System.out.println(map1.put(new Element("").getKey(),""));
			}
			
			System.out.println(map1.toString());
		}
	}
}
