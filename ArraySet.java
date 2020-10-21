/* CSC 300 Spring 2019 -- Lytinen
   Homework 3 part 1:  ArraySet
   Similar to ArrayBag
 */
package hw3;

import java.util.Iterator;

public class ArraySet<T> implements Set300<T> {

	protected T[] items;
	protected int size;
	
	// creates an empty set
	// just like the constructor for ArrayBag
	public ArraySet(int capacity) {
		items = (T[]) new Object[capacity];
		size = 0;
	}
	// DON'T add if the array is full, or if item is already
	// in the set.  Return false in these cases.  Otherwise,
	// return true.
	public boolean add(T item) {
		if (contains(item))
			return false;
		if (isFull()) expand() ;
		items[size++] = item;
		return true;
	}
	private boolean isFull() {
		return size == items.length;
	}
	
	private void expand() {
		T temp[] = (T [ ]) new Object[items.length*2];
		for (int i=0; i<size; i++)
			temp[i] = items[i];
		items = temp;
	}
	
	// remove the item, if it's in the set, and return true.
	// If it's not in the set, return false
	public boolean remove(T item) {
		for (int i=0; i<size; i++)
			if(item.equals(items[i])) {
				shiftLeft(i); 
				size--;
				return true;
			}
		return false;
	}
	private void shiftLeft(int idx) {
		for(int i=idx; i<size-1;i++)
			items[i]=items[i+1];
	}
	// identical to ArrayBag's iterator
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int i=0;
			
			public boolean hasNext() {
				return i < size;
			}
			
			public T next() {
				return items[i++];
			}
		};
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder("{ ");
		for (T item: this) {
			b.append(item.toString() + " ");
		}
		b.append("}");
		return b.toString();
	}	
}