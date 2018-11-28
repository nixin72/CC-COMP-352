package a4_40082638_40042586;

import java.util.Arrays;

public class MyHashTable_LinearProbing extends MyHashTable {
	private Element[] elements;
	private int size;
	
	public MyHashTable_LinearProbing() {
		elements = new Element[10];
		this.size = 0;
	}
	
	public MyHashTable_LinearProbing(int size) {
		elements = new Element[size];
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size == elements.length;
	}

	@Override
	public Element get(int key) {
		return elements[key];
	}

	@Override
	public Element put(int key, String value) {
		Element element = new Element(key,value);
		int hashCode = element.hashCode();
		if (!isFull()) {
			try {
				while(hasCollision(hashCode%size)) {
					hashCode++;
				}
			}
			catch(ArithmeticException e) {
				System.out.println("hi");
				elements[0] = element;
			}
			elements[hashCode%size]=element;
			size++;
		}
		return element;
	}

	@Override
	public Element remove(int key) {
		Element e = elements[key%size];
		elements[key%size] = null;
		size--;
		return e;
	}
	
	private boolean hasCollision(int index) {
		return elements[index] != null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyHashTable_LinearProbing map = new MyHashTable_LinearProbing(100);
		
		map.put(3, "hi");
		map.put(3, "hamza");
		System.out.println(map.toString());
	}
}
