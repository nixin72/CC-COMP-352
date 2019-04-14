package a3_40082638;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Class Name: MyArrayList<E>
 * Extends: N/A
 * Implements: List<E>
 * 
 * - list: E
 * - lastIndex: int
 * - OP: enum
 * 
 * <<constructor>> + MyArrayList(initialSize : int)
 * + add(element : E) : boolean
 * + add(index : int, element : E) : void
 * + clear() : void
 * + remove(o : Object) : boolean
 * + remove(index : int) : E
 * + size() : int
 * + toString() : String
 * - increaseSize(size : int) : void
 * - decreaseSize(size : int) : void
 * - mod(index : int, t : OP) : void
 * 
 */
public class MyArrayList<E> implements List<E> {
	private static enum OP {
		ADD, REMOVE
	};
	
	private E[] list;
	private int lastIndex;	
	
	/*
	 * @Purpose: 
	 * 	Initialize the underlying array to an empty array of length
	 * 	1 and to set the lastIndex to -1. 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {			
		list = (E[]) new Object[1];
		lastIndex = -1;
	}
	
	/*
	 * @Input: an integer representing the initial size of the array. 
	 * 
	 * @Purpose: 
	 * 	Initialize the underlying array to an empty array of length
	 * 	initialSize and to set the lastIndex to -1. 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialSize) {			
		list = (E[]) new Object[initialSize];
		lastIndex = -1;
	}
	
	/*
	 * @Input: Object of generic type <E>
	 * 
	 * @Purpose: 
	 * 	Add an element to the end of the array. Since the array
	 * 	gets padded whenever it needs to be expanded, this adds
	 * 	at the lastIndex+1 so that it doesn't create a bunch of 
	 * 	nulls between itself and the previous last index.
	 * 
 	 * @Output: true  
	 */
	@Override
	public boolean add(E element) {
		add(lastIndex+1, element);
		return true;
	}

	/*
	 * @Input: The element to add, and the index to add it at. 
	 * 
	 * @Purpose: 
	 * 	Add an element at the specified index in the underlying 
	 * 	array. First do any necessary resizing of the array and 
	 * 	then shift every element in the array one to the right. 
	 * 	Then at the specified index, set the value in the array
	 * 	to be the element passed in to the method. 
	 * 
	 * @Output: Void
	 */
	@Override
	public void add(int index, E element) {
		mod(index, OP.ADD);

		for (int q = lastIndex-1 ; q >= index ; q--) {
			list[q+1] = list[q];
		}
		list[index] = element;
	}

	/*
	 * @Input: NONE
	 * 
	 * @Purpose:
	 * 	To clear the array list of all elements and reset the 
	 * 	lastIndex to it's original value of -1. 
	 * 
	 * @Output: Void
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		list = (E[]) Array.newInstance(this.getClass(), 1);
		lastIndex = -1;
		
	}

	/*
	 * @Input: index to remove from
	 * 
	 * @Purpose: 
	 * 	Remove the element at the give index in the array. Then shift
	 * 	the whole array over so that index isn't null.
	 * 
	 * @Output:
	 * 	The element removed if it was successful. Otherwise, null.
	 * */
	@Override
	public E remove(int index) {
		if (index < 0 || index > lastIndex) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + lastIndex);
		}
		
		mod(index, OP.REMOVE);
				
		E old = list[index];
		for (int q = index ; q < list.length-1 ; q++) {
			list[q] = list[q+1];
		}
		
		lastIndex--;
		return old;

	}
	
	/*
	 * @Input: The object to remove from the array. 
	 * 
	 * @Purpose: 
	 * 	Remove the first instance of the object passed into the array.
	 * 	Once it has been removed, loop through the entire array and 
	 * 	shift everything over by one.
	 * 
	 * @Output:
	 * 	A boolean indicating whether or not the element was successfully
	 * 	removed from the array. 
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		int index = -1;
		boolean found = false; 
		for (int q = 0 ; q < list.length || !found; q++) {
			if (((E) o).equals(list[q])) {
				index = q;
				found = true;
			}
		}
		
		if (found) {
			remove(index);
		}
		
		return found;
	}

	/*
	 * @Input: NONE
	 * 
	 * @Purpose: 
	 * 	Tell the user the length of the array. This doesn't return
	 * 	the size because once the array size gets doubled in size, 
	 * 	it gets padded with null values that as far as the user is
	 * 	concerned are NOT a part of their array list. So instead I
	 * 	return the last non-null index.
	 * 
	 * @Output: The last non-null index in the array. 
	 * */
	@Override
	public int size() {
		return lastIndex;
	}	
	
	/*
	 * @Input: NONE
	 * 
	 * @Purpose:
	 * 	Override of the default Object toString method. 
	 * 
	 * @Output: A String representation of this.    	
	 * */
	@Override
    public String toString() {
		String toString = "[";
		for (int q = 0 ; q <= lastIndex ; q++) {
			if (list[q] != null) {
				toString += list[q].toString() + ", ";
			}
		}
		
		try {
			return toString.substring(0, toString.length()-2) + "]";
		}
		catch (IndexOutOfBoundsException e) {
			return "[]";
		}
        
    }
	
	/*
	 * @input: The index that the operation is being performed on. 
	 * 
	 * @Purpose: 
	 * 	This method is going to double the size of the array until 
	 * 	the array is large enough to insert at the given index. It 
	 * 	will then copy all elements from the original array into a
	 * 	new array that's large enough to contain all the elements. 
	 * */
	private void increaseSize(int size) {
		int newLength = list.length;
		
		do {
			newLength <<= 1;
		}
		while (size > newLength);
		
		@SuppressWarnings("unchecked")
		E[] newList = (E[]) new Object[newLength];
		for (int i = 0 ; i < list.length ; i++) {
			newList[i] = list[i];
		}
		
		this.list = newList;
	
	}
	
	/*
	 * @input: The index that the operation is being performed on. 
	 * 
	 * @Purpose: 
	 * 	This method is going to halve the size of the array until 
	 * 	it's as small as it can make it, while still being larger
	 * 	the lastIndex in the array. Once the new size is decided,
	 * 	it will copy all of the elements from the original array 
	 *  into a new array that's big enough to contain all of the 
	 *  elements. 
	 * */
	private void decreaseSize(int size) {
		int newLength = list.length;
		do {
			newLength >>= 1;
		}
		while (size >= newLength);
		
		
		@SuppressWarnings("unchecked")
		E[] newList = (E[]) new Object[newLength];
		for (int i = 0 ; i < lastIndex ; i++) {
			newList[i] = list[i];
		}
		
		this.list = newList;
	}
	
	/*
	 * @input: The index your operation is being performed on
	 * @input: The type of operation being performed
	 * 
	 * @Purpose: 
	 * 	The purpose of this method is to determine any work that 
	 * 	needs to be done on an array either prior to inserting or 
	 * 	after removing an element. This method will decide if the 
	 * 	underlying array needs to be doubled in size, or if it 
	 * 	needs to be halved once the array size gets small enough.  
	*/
	private void mod(int index, OP t) {
		switch (t) {
			case ADD: {
				if (index >= (list.length * 3) / 4) {					
					lastIndex = index;
					increaseSize(lastIndex);
				}
				else {
					lastIndex++;
				}
			}break;
			case REMOVE: {
				if (lastIndex <= list.length / 4) {
					decreaseSize(index);
				}
			}break;
			default:
				break;
		}
	}
	
	/*
     ************************************************************************************************
     * Unsupported Methods
     ************************************************************************************************
     */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}	
	
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}	

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
}