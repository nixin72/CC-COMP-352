package a3_40082638;

public abstract class MyPriorityQueue<E> {
	public abstract E peek();
	public abstract E remove();
	public abstract void add(E element);
	public abstract int size();
	public abstract boolean isEmpty();
	public abstract String toString();
	public abstract boolean reprioritize();
}
