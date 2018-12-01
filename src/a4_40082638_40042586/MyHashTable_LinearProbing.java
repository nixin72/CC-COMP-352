package a4_40082638_40042586;

import java.util.Arrays;
import java.util.Random;

public class MyHashTable_LinearProbing extends MyHashTable {
	int p,b,c;
	
	private Element[] elements;
	
	public MyHashTable_LinearProbing() {
		super();
		elements = new Element[getCapacity()];
		p = nextPrime(capacity);
		b = new Random().nextInt(capacity-1);
		c = new Random().nextInt(capacity-2)+1;
	}
	
	public MyHashTable_LinearProbing(int capacity) {
		super(capacity);
		elements = new Element[capacity];
		p = nextPrime(capacity);
		b = new Random().nextInt(capacity-1);
		c = new Random().nextInt(capacity-2)+1;
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
		return elements[key];
	}
	

	@Override
	public Element put(int key, String value) {
        Element element;
        int hashCode;
		try {
			if(findElement(key).getKey()!=key) {
				throw new NullPointerException();
			}
			else {
			findElement(key).setValue(value);
			return findElement(key);}
		}
		catch(NullPointerException e) {
			element = new Element(key,value);
			hashCode = element.hashCode();
			while(hasCollision(compress(hashCode))) {
				hashCode++;
			}
		}
		size++;
		elements[compress(hashCode)] = element;
		return element;
	}

	@Override
	public Element remove(int key) {
		Element e = elements[compress(capacity)];
		elements[compress(capacity)] = null;
		size--;
		return e;
	}
	
	@Override
	protected boolean hasCollision(int index) {
		return elements[index] != null;
	}
	
	@Override
	protected int compress(int hashcode) {
		//MAD compression method
		return ((((c*hashcode)+b)%p) & 0x7fffffff)%capacity;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyHashTable_LinearProbing map = new MyHashTable_LinearProbing();
		
		map.put(3, "hamza");
		map.put(8, "ahmed");
		map.put(13, "abdulrahman");
		map.put(3, "sara");
		System.out.println(map.toString());
	}
}
