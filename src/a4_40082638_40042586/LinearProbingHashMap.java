package a4_40082638_40042586;

import java.util.Arrays;

public class LinearProbingHashMap implements HashMap{
	private Element[] elements;
	private int size;
	
	public LinearProbingHashMap(int size) {
		elements = new Element[size];
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	public boolean isFull() {
		return size == elements.length;
	}

	@Override
	public String get(int key) {
		// TODO Auto-generated method stub
		return elements[key].getValue();
	}

	@Override
	public void put(int key, String value) {
		Element element = new Element(key,value);
		int hashCode = element.hashCode();
		if(!isFull()) {
			try {
		while(collision(hashCode%size)) {
			hashCode++;
			}}
			catch(ArithmeticException e) {
				System.out.println("hi");
				elements[0]=element;
				return;
				
			}
		elements[hashCode%size]=element;
		size++;
		}
		
	}

	@Override
	public void remove(int key) {
	elements[key%size] = null;
	size--;
			
		
	}
	
	public boolean collision(int index) {
		if(elements[index]!=null) {
			return true;
		}
		else return false;
	}
	
	
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		LinearProbingHashMap map = new LinearProbingHashMap(100);
		map.put(3, "hi");
		map.put(3,"hamza");
		System.out.println(map.toString());
		
	}

}
