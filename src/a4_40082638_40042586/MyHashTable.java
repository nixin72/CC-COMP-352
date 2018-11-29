package a4_40082638_40042586;

public abstract class MyHashTable {
	public abstract int size();
	public abstract boolean isEmpty();
	public abstract boolean isFull();
	public abstract Element get(int key);
	public abstract Element put(int key, String value);
	public abstract Element remove(int key);
}