package hw3;
//Fix lol
import java.util.Arrays;
import java.util.Iterator;

public class OrderedSet<T> implements Set300<T> {
	protected Comparable<T> items;
	protected int size;
	
	public OrderedSet(int capacity) {
		items=(T[])new Comparable[capacity];
		size=0;
	}
	public boolean add(T item) {
		if (contains(item))
			return false;
		if (isFull()) expand();
		for(int i=0;i<size;i++)
			if(item.compareTo((T) items[i])<0) {
				shiftRight[i];
				items[i]=item;
				size++;
				return true;
	items[size++]=items;
			return true;
	}

	private boolean isFull() {
		return size == items.length;
	}
	
	private void expand() {
		Comparable<T> = (T [ ]) new Comparable[items.length*2];
		for (int i=0; i<size; i++)
			temp[i] = items[i];
		items = temp;
	}
	public boolean remove(T item) {
		for (int i=0; i<size; i++)
			if(item.equals(items[i])) {
				shiftRight(i); 
				size--;
				return true;
			}
		return false;
	}
	private void shiftRight(int idx) {
		for(int i=idx; i<size-1;i++)
			items[i]=items[i+1];
	}
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
