package a4_40082638_40042586;

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class MyHashTable_LinearProbing extends MyHashTable {
	private int p,b,c;
	private int probingattempts = 0;
	
	private Element[] elements;
	
	public MyHashTable_LinearProbing() {
		super();
		elements = new Element[getCapacity()];
		p = nextPrime(capacity);
		b = new Random().nextInt(capacity-1);
		c = new Random().nextInt(capacity-2)+1;
		setLoadFactor(0.5);
	}
	
	public MyHashTable_LinearProbing(int capacity) {
		super(capacity);
		elements = new Element[capacity];
		p = nextPrime(capacity);
		b = new Random().nextInt(capacity-1);
		c = new Random().nextInt(capacity-2)+1;
		setLoadFactor(0.5);
}
 

	
	protected Element findElement(Integer key) {
        return elements[compress(new Element(key,"").hashCode())];
		}
	
	public void resize(int newcap) {
	Element[] newelem = new Element[newcap];
	for(int i = 0; i<capacity;i++) {
		newelem[i]=elements[i];
	}
	elements = newelem;
	capacity = newcap;
	p = nextPrime(capacity);
	b = new Random().nextInt(capacity-1);
	c = new Random().nextInt(capacity-2)+1;
	}
	

	@Override
	public Element get(int key) {
		return findElement(key);
	}
	

	@Override
	public Element put(int key, String value) {
		Instant start = Instant.now();
        int probez = 0;
        Element element;
        int hashCode;
		try {
			if(findElement(key).getKey()!=key) {
				throw new CollisionException();
			}
			else {
			findElement(key).setValue(value);
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("capacity of the table:" + capacity);
			System.out.println("Size of the table:" + size);
			System.out.println("Probing attempts:" + probez);
			System.out.println("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			return findElement(key);}
		}
		catch(CollisionException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			while(hasCollision(compress(hashCode))) {
				probez++;
				probingattempts++;
				hashCode++;
			}
		}
		catch(NullPointerException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			elements[compress(hashCode)] = element;
		}
		size++;
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		element = new Element(key,value);
		elements[compress(hashCode)] = element;
		if((double) size/capacity>=loadfactor) {
			resize(nextPrime(capacity*2));
		}
		System.out.println(start);
		System.out.println(end);
		System.out.println("capacity of the table:" + capacity);
		System.out.println("Size of the table:" + size);
		System.out.println("Probing attempts:" + probez);
		System.out.println("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
		return element;
	}

	@Override
	public Element remove(int key) {
		Instant start = Instant.now();
        Element element;
        int hashCode;
		try {
			element = new Element(findElement(key));
			if(findElement(key).getKey()!=key) {
				throw new CollisionException();
			}
			else {
				
			findElement(key).setValue(null);
			findElement(key).setKey(null);
			findElement(key).setAvailable(true);
			return element;}
		}
		catch(CollisionException e) {
			hashCode = new Element(key,null).hashCode();
			while(hasCollision(compress(hashCode))) {
				if(key==elements[compress(hashCode)].getKey()) {
					break;}
				probingattempts++;
				hashCode++;
			}
		}
		catch(NullPointerException e) {
			return null;
		}
		try {
		element = new Element(elements[compress(hashCode)]);
		elements[compress(hashCode)].setAvailable(true);
		elements[compress(hashCode)].setKey(null);
		elements[compress(hashCode)].setValue(null);
		size--;}
		catch(NullPointerException e) {
			return null;
		}          
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
		return element;
		
	}
	
	@Override
	protected boolean hasCollision(int index) {
		try {
		return elements[index].available==false;
		}
		catch (NullPointerException e) {
			return false;
		}
	}
	
	@Override
	protected int compress(int hashcode) {

		return (hashcode & 0x7fffffff)%capacity;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyHashTable_LinearProbing map = new MyHashTable_LinearProbing();
		for(int i = 0; i < 100; i++) {
			Element a = new Element("");
			map.put(a.getKey(),"JOB"+i);
		}
		System.out.println(map.toString());
		for(int i = 0; i<50; i++) {
			System.out.println(map.remove(i));
		}
		System.out.println(map.toString());
	}
}
