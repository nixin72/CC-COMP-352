
package a4_40082638_40042586;

import java.util.ArrayList;
import java.util.Arrays;

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
 

	protected Element findElement(Integer key) {
        return elements[compress(new Element(key,"").hashCode())];
	}
	
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

	@Override
	protected boolean hasCollision(int index) {
		try {
			return elements[index].available == false;
		}
		catch (NullPointerException e) {
			return false;
		}
	}
	
	@Override
	protected int compress(int hashcode) {
		return (hashcode & 0x7fffffff) % capacity;
	}
	
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