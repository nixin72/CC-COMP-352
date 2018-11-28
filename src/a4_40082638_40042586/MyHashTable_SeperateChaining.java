package a4_40082638_40042586;

import java.util.Arrays;

public class MyHashTable_SeperateChaining extends MyHashTable {
	private Element[] elements;
	private int size;
	
	public MyHashTable_SeperateChaining() {
		elements = new Element[10];
		this.size = 0;
	}
	
	public MyHashTable_SeperateChaining(int size) {
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
	public String get(int key) {
		return elements[key].getValue();
	}

	@Override
	public void put(int key, String value) {
		Element element = new Element(key,value);
		int hashCode = element.hashCode();
		if (!isFull()) {
			try {
				int probe = 1;
				while(hasCollision(hashCode%size)) {
					hashCode = (int) Math.pow(probe++, 2);
				}
				
				elements[hashCode%size] = element;
				size++;
			}
			catch (ArithmeticException e) {
				System.out.println("hi");
				elements[0] = element;
			}
		}
	}

	@Override
	public void remove(int key) {
		elements[key%size] = null;
		size--;
	}
	
	private boolean hasCollision(int index) {
		return elements[index] != null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyHashTable_SeperateChaining map = new MyHashTable_SeperateChaining(100);
		map.put(3, "hi");
		map.put(3,"hamza");
		System.out.println(map.toString());
	}
}
