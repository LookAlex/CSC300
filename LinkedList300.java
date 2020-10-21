package hw6;

import java.util.Iterator;

// a singly linked list
// makes removing the last item very difficult

public class LinkedList300<T> implements List300<T> {

	private class Node<T> {
		public T item;
		public Node next;
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public LinkedList300() {
		first = null;
		last = null;
		size = 0;
	}

	public String toString() {
		if (size == 0) return "[]";
		StringBuilder b = new StringBuilder("[");
		for (T item : this)
			b.append(item + ", ");
		// get rid of the ", "
		b.delete(b.length()-2, b.length());
		b.append("]");
		return b.toString();
		}
	
	// In the test code, I call listEquals occasionally to make
	// sure that my methods do the same thing as the corresponding
	// Java ArrayList or LinkedList methods.  That is why the 
	// print statements are in the code.  Once I'm certain the code 
	// works properly, I would take them out.
	public boolean listEquals(Iterable<T> javaList) {
		Iterator<T> it = iterator(), javaIt = javaList.iterator();
		int i;
		for (i=0; it.hasNext() && javaIt.hasNext(); i++) {
			T mine = it.next();
			T other = javaIt.next();
			if (!mine.equals(other)) {
				System.out.println("lists are not equal at index " + i);
				return false;
			}
		}
		if (it.hasNext() != javaIt.hasNext()) {
			System.out.println("lists are not equal at index " + i);
			return false;
		}
		return true;
	}

	// add at the end
	public boolean add(T item) { 
		if (first == null) {
			first = new Node<T>(item, null);
			last = first;
		}
		else {
			last.next = new Node<T>(item, null);
			last = last.next;
		}
		size++;
		return true;
	}

	public boolean add(int idx, T item) {
		if (idx == 0) {
			Node<T> newNode = new Node<T>(item, first);
			first = newNode;
			if (last== null) last = newNode;
		}
		else if (idx > size) 
			return false;
		else if (idx == size) {
			last.next = new Node<T>(item, null);
			last = last.next;
		}
		else {
			Node<T> n = first;
			for (int i=1; i<idx; i++)
				n = n.next;
			n.next = new Node<T>(item, n.next);
			if (last == n)
				last = n.next;
		}
		size++;
		return true;
	}

	public T set(int idx, T item) {
		
		return null;
	}

	public boolean contains(T item) {
		for (T i:this)
			if(i.equals(item))
			return true;
		return false;
	}

	public T get(int idx) {
		Node<T> head=first;
		int p=0;
		while(head!=null)
			if(p==idx)
				return head.item;
		if(head.next!=null)
			head=head.next;
		else
			return null;
		p++;
		return head.item;
		}

	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/* I didn't bother to write these.  You don't need to either. */	
	public boolean remove(T item) {
		return false;
	}
    
	public T remove(int idx) {
		return null;
	}
	
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> n = first;
			
			public boolean hasNext() {
				return n != null;
			}
			
			public T next() {
				T answer = n.item;
				n = n.next;
				return answer;
			}
		};
	}
}
