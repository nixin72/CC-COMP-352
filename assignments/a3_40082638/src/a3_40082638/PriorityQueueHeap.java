package a3_40082638;

/*
 * ClassName: PriorityQueueHeap
 * Generic: E extends Comparable<E>
 * 
 * - list : MyArrayList<E>
 * 
 * <<constructor>> + PriorityQueueHeap()
 * 
 * + peek() : E
 * + remove() : E
 * + add(element : E) : E
 * + size() : int
 * + toString() : String 
 */
public class PriorityQueueHeap<E extends Comparable<E>> extends MyPriorityQueue {
	private MyArrayList<E> list;
	
	public PriorityQueueHeap() {
		list = new MyArrayList<E>();
	}
	
	public E peek() {
		return list.get(0);
	}
	
	public E remove() {
		return list.remove(0);
	}
	
	public void add(E element) {		
		int q = 0;
		for (; element.compareTo(list.get(q)) <= 0 ; q++);
		
		list.add(q, element);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public String toString() {
		return list.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriorityQueueHeap<E> other = (PriorityQueueHeap<E>) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object element) {
		this.add((E) element); 
		
	}

	@Override
	public boolean reprioritize() {
		return false;
	}
}