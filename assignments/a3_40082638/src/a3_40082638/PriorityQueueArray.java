package a3_40082638;

/*
 * ClassName: PriorityQueueArray
 * Generic: E extends Comparable<E>
 * 
 * - list : MyArrayList<E>
 * 
 * <<constructor>> + PriorityQueueArray()
 * 
 * + peek() : E
 * + remove() : E
 * + add(element : E) : E
 * + size() : int
 * + toString() : String 
 */

public class PriorityQueueArray<E extends Comparable<E>> extends MyPriorityQueue {
	private MyArrayList<E> list;
	
	/*
	 * Purpose:
	 * 	Construct a new instand of a PriorityQueueArray object.
	 */
	public PriorityQueueArray() {
		list = new MyArrayList<E>();
	}
	
	/*
	 * Purpose: 
	 *  Check the first element of the queue
	 *  
	 * Output: E   
	 */
	public E peek() {
		return list.get(0);
	}
	
	/*
	 * Purpose:
	 *  Remove the first element from the queue
	 *  
	 *  Output: E
	 */
	public E remove() {
		return list.remove(0);
	}
	
	/*
	 * Input: E
	 * 
	 * Purpose: 
	 *  Add an element to the queue in sorted order
	 *  
	 * Output: void
	 */
	public void add(E element) {		
		int q = 0;
		for (; element.compareTo(list.get(q)) <= 0 ; q++);
		
		list.add(q, element);
	}
	
	/*
	 * Purpose: 
	 * 	Output how many items are sitting in the queue
	 * 
	 * Output: int
	 */
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	

	
	/*
	 * Purpose: 
	 * 	Create a string representation of the queue
	 * 
	 * Output: String
	 */
	public String toString() {
		return list.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object element) {
		this.add((E) element);
	}
	
	/*
	 * Ideally the way this would be implemented would be with 
	 * higher-order functions. Give the PriorityQueueX a 
	 * re-prioritize method that allows a lambda function as a parameter, 
	 * which you can then pass in a function that checks the object 
	 * state and determines the re-prioritization based off of the 
	 * passed function. That's how I would do this if it was JavaScript 
	 * or Python, or some other good language. 
	 */
	@SuppressWarnings({ "unchecked" })
	public boolean reprioritize() {
		boolean isStarvedFound = false;
		for(int i = 0; i < this.size(); i++) {
			if (!isStarvedFound)
				if (!((Job)list.get(i)).isProcessed()) {
					isStarvedFound = true;
					Job job = (Job) list.get(i);
					for(int j = i; j < size() - 1; j++) {
	                    list.set(j, list.get(j+1));
	                };
					job.setFinalPriority(1);
					job.setExecutedOn(job.getExecutedOn() + 1);
					this.add((E) job);
				}
		}
		return isStarvedFound;
	}
}
