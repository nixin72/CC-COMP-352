package a4_40082638_40042586;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyHashTable_SeperateChaining extends MyHashTable {
	private int probingattempts = 0;
	
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

	
	
	@SuppressWarnings("unchecked")
	public void resize(int newcap) {
		ArrayList<Element> newelem[] = (ArrayList<Element>[])new ArrayList[newcap];
		for (int i = 0 ; i < capacity ; i++) {
			newelem[i] = elements[i];
		}
		
		elements = newelem;
		capacity = newcap;
	}
	

	@Override
	public Element get(int key) {
		return findElement(key);
	}
	

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
				probingattempts++;
				hashCode = (int) Math.pow(probez, 2);
			}
		}
		catch (NullPointerException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			try {
				elements[compress(hashCode)].set(key, element);
			}
			catch (NullPointerException err) {
				elements[compress(hashCode)] = new ArrayList<Element>();
				elements[compress(hashCode)].set(key, element);
			}
		}
		
		size++;
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		element = new Element(key,value);
		elements[compress(hashCode)].set(key, element);
		
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
				if (key == elements[compress(hashCode)].get(key).getKey()) {
					break;
				}
				probez++;
				probingattempts++;
				hashCode = (int) Math.pow(probez, 2);
			}
		}
		catch (NullPointerException e) {
			return null;
		}
		
		
		try {
			element = new Element(elements[compress(hashCode)].get(key));
			elements[compress(hashCode)].get(key).setAvailable(true);
			elements[compress(hashCode)].get(key).setKey(null);
			elements[compress(hashCode)].get(key).setValue(null);
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
	
	protected Element findElement(Integer key) {
        return elements[compress(new Element(key, "").hashCode())].get(key);
	}
	
	
	@Override
	protected int compress(int hashcode) {
		return (hashcode & 0x7fffffff) % capacity;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyHashTable_LinearProbing map = new MyHashTable_LinearProbing();
		for (int i = 0 ; i < 100 ; i++) {
			Element a = new Element("");
			map.put(a.getKey(), "JOB" + i);
		}
		System.out.println(map.toString());
		
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println(map.remove(i));
		}
		System.out.println(map.toString());
	}
}
