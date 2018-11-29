package a4_40082638_40042586;

public abstract class MyHashTable {
	private int size;
	
	public MyHashTable(int size){
		this.size = size;
	}
	
	public MyHashTable() {
		this.size = 8;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public abstract boolean isFull();
	public abstract Element get(int key);
	public abstract Element put(int key, String value);
	public abstract Element remove(int key);
}