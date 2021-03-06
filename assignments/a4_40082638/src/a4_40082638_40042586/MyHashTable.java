package a4_40082638_40042586;

/*
 * Class Name: __MyHashTable__
 * 
 * # size: int
 * # capacity: int
 * # loadfactor: double
 * #* INITIAL_CAPACITY: int 
 * 
 * <<constructor>> + MyHashTable()
 * <<constructor>> + MyHashTable(capacity : int)
 * + getSize() : int
 * + getCapacity() : int
 * + getLoadFactor() : int
 * + setSize(size : int): void
 * + setCapacity(capacity : int) : void
 * + setLoadFactor(loadFactor : int) : void
 * + isEmpty() : boolean
 * # nextPrimt(input : int) : int
 * __# compress(hashcode : int) : int__
 * __# hasCollision(index : int) : boolean__
 * __+ get(index : int) : Element__
 * __+ put(key : int, value : String) : Element__
 * __+ remove(key : int) : Element__
 * 
 */
public abstract class MyHashTable {
	protected int size;
	protected int capacity;
	protected double loadfactor;
	protected static final int INITIAL_CAPACITY = 5;
	
	public MyHashTable(int capacity){
		this.size = 0;
		this.capacity = capacity;
		this.loadfactor = 0.75; 
	}
	
	public MyHashTable() {
		this.size = 0;
		this.capacity = INITIAL_CAPACITY;
		this.loadfactor = 0.75; 
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public double getLoadFactor() {
		return loadfactor;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setLoadFactor(double newloadfactor) {
		this.loadfactor = newloadfactor;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	protected int nextPrime(int input){
		int counter;
		input++;   
		while (true){
			counter = 0;
			for (int i = 2; i <= Math.sqrt(input); i++){
				if (input % i == 0)  
					counter++;
			}
			
			if (counter == 0)
				return input;
			else {
				input++;
				continue;
			}
		}
	}
	
	protected abstract int compress(int hashcode);
	protected abstract boolean hasCollision(int index);
	
	public abstract Element get(int key);
	public abstract Element put(int key, String value);
	public abstract Element remove(int key);
}