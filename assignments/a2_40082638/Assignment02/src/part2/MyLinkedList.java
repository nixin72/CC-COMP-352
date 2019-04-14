package part2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Class Name: MyLinkedList<E>
 * Extends: N/A
 * Implements: List<E>
 * 
 * 	Inner Class: Node<T>
 * 
 * 	- head : Node<E>
 * 	- tail : Node<E>
 * 	- size : int
 * 
 * 	<<constructor>> + MyLinkedList(initialSize : int)
 * 	+ add(element : E) : boolean
 * 	+ add(index : int, element : E) : void
 * 	+ clear() : void
 * 	+ remove(o : Object) : boolean
 * 	+ remove(index : int) : E
 * 	+ size() : int
 * 	+ toString() : String
 * 
 * */
public class MyLinkedList<E> implements List<E> {
	/*
	 * Class Name: Node<T>
	 * Extends: N/A
	 * Implements: N/A
	 * 	- data : E
	 * 	- predecessor : Node<E>
	 * 	- successor : Node<E>
	 * 
	 *  <<constructor>> + Node()
	 *  <<constructor>> + Node(data : E)
	 *  <<constructor>> + Node(data : E, predecessor : Node<E>)
	 *  <<constructor>> + Node(data : E, predecessor : Node<E>, successor : Node<E>)
	 *  
	 *  + getDate() : E
	 *  + getSuccessor() : Node<E>
	 *  + getPredecessor() : Node<E>
	 *  + setDate(data : E) : void
	 *  + setSuccessor(successor : Node<E>) : void
	 *  + setPredecessor(predecessor : Node<E>) : void
	 *  + toString() : String
	 * */
    class Node<T> {
        private E data;
        private Node<E> predecessor;
        private Node<E> successor; 

        public Node() {
            this.data = null;
            this.predecessor = null;
            this.successor = null;
        }

        public Node(E data) {
            this.data = data;
            this.predecessor = null;
            this.successor = null;
        }

        public Node(E data, Node<E> predecessor) {
            this.data = data;
            this.predecessor = predecessor;
            this.successor = null;
        }

        public Node(E data, Node<E> predecessor, Node<E> successor) {
            this.data = data;
            this.predecessor = predecessor;
            this.successor = successor;
        }

        public E getData() {
            return data;
        }

        public Node<E> getSuccessor() {
            return successor;
        }

        public Node<E> getPredecessor() {
            return predecessor;
        }

        public void setData(E data) {
            this.data = data;
        }

        public void setSuccessor(Node<E> successor) {
            this.successor = successor;
        }

        public void setPredecessor(Node<E> predecessor) {
            this.predecessor = predecessor;
        }
        
        @Override
        public String toString() {
        	if (data == null) {
        		return null;
        	}
        	return data.toString();
        }
    }

    private Node<E> head;
    private Node<E> tail; 
    private int size;
	
    /*
	 * @Input: NONE 
	 * 
	 * @Purpose: 
	 * 	Initialize the head/tail to be null, and the size to be 0
	 * 
	 * */
	public MyLinkedList() {	
        head = null;
        tail = null;
        size = 0;
    }
      
	/*
	 * @Input: Object of generic type <E>
	 * 
	 * @Purpose: 
	 * 	Add an element to the end of the array. If the head is null,
	 * 	set it as the head and the tail. Otherwise, point the tail 
	 *  to the new element.
	 * 
 	 * @Output: true  
	 * */
	@Override
	public boolean add(E e) {
        if (head == null) {
            head = new Node<E>(e);
            tail = head;
        }
        else {
            Node<E> newTail = new Node<E>(e, tail);
            tail.setSuccessor(newTail);
            tail = newTail;            
        }

        this.size++;
        return true;
	}

	/*
	 * @Input: The element to add, and the index to add it at. 
	 * 
	 * @Purpose: 
	 * 	Add an element at the specified index in the linked list. 
	 *  Loop through the array from either the beginning or the 
	 *  end, depending on what index it is, and insert it between
	 *  two elements. 
	 * 
	 * @Output: Void
	 * */
	@Override
	public void add(int index, E e) {
        if (index < 0 || index > size) {
        	throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
				
		if (index == 0) {
			Node<E> newNode = new Node<E>(e);
			if (head != null) {
				head.setPredecessor(newNode);
				newNode.setSuccessor(head);
			}
			else {
				tail = newNode;
			}
			head = newNode;
		}
		else {
			Node<E> curr = head;
	        for (int counter = 0 ; counter < index-1 ; counter++) {
	            curr = curr.getSuccessor();
	        }
	        
	        Node<E> successor = curr.getSuccessor();
	        Node<E> newNode = new Node<E>(e, curr, successor);
	        
	        if (successor != null)
	        	successor.setPredecessor(newNode);
	        else {
	        	tail.setSuccessor(newNode);
	        	tail = newNode;
	        }
	        	
	        curr.setSuccessor(newNode);
		}

        this.size++;
	}

	/*
	 * @Input: NONE
	 * 
	 * @Purpose:
	 * 	To clear the list of all elements by setting the head and tail to both
	 * 	point to null, and setting the size of the list to be 0.
	 * 
	 * @Output: Void
	 * */
	@Override
	public void clear() {
        head = null;
        tail = null;
        size = 0;
	}

	@Override
	public boolean remove(Object o) {
		System.out.println(this.toString());
		
        Node<E> e = head;
        while (e != null) {
        	System.out.println(e);
            if (e.getData().equals(o)) {
                Node<E> successor = e.getSuccessor();
                Node<E> predecessor = e.getPredecessor();
                successor.setPredecessor(predecessor);
                predecessor.setSuccessor(successor);

                size--;
                return true;
            }

            e = e.getSuccessor();
       }

      return false;
	}

	@Override
	public E remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        E removed;
        if (index == 0) {
        	Node<E> newHead = head.getSuccessor();
        	
        	removed = head.getData();
        	try {
        		newHead.setPredecessor(null);
            	head = newHead;
        	}
        	catch (NullPointerException e) {
        		head = null;
        		tail = null;
        		this.size = 0;
        	}        	
        }
        else {
	        Node<E> curr = head;
	        for (int counter = 0 ; counter < index-1 ; counter++) {
	            curr = curr.getSuccessor();
	        }
	
	        removed = curr.getData();
	        Node<E> successor = curr.getSuccessor();
	        Node<E> predecessor = curr.getPredecessor();
	        predecessor.setSuccessor(successor);
	        successor.setPredecessor(predecessor);	
        }

        this.size--;
        return removed;
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
        Node<E> curr = head;
        String toString = "[";
        
        while (curr != null) {
            toString += curr.toString() + ", ";
            curr = curr.getSuccessor();
        }

        try {
        	return toString.substring(0, toString.length()-2) + "]";
        }
        catch (StringIndexOutOfBoundsException e) {
        	return "[]";
        }
    }

    /*
	 * @Input: NONE
	 * 
	 * @Purpose: 
	 * 	Tell the user the length of the array. 
	 * 
	 * @Output: The number of nodes in the list.
	 * */
	@Override
	public int size() {
        return this.size;
	}
    
    /*
     ************************************************************************************************
     * Unsupported Methods
     ************************************************************************************************
     */
    @Override
	public E set(int index, E element) {
        throw new UnsupportedOperationException();
	}
	
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
	public Object[] toArray() {
        throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
	}
}