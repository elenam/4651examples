/**
 * 
 * The class implements a min-priority queue, i.e. smaller numbers 
 * have higher priority. For instance, if the queue contains 
 * 2, 4, 1, then 1 is returned first, then 2, then 4. 
 * The smallest element in the queue is called the head of the queue. 
 * If the queue contains several elements with the same minimal value,
 * any one of them may play the role of the head. 
 *  
 * Elements inserted in the the queue must implement Comparable interface.
 * They are ordered based on the ordering determined by their 
 * compareTo method. 
 *
 * @param <E> - type of elements in the queue. Must implement Comparable<E>
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurPriorityQueue<E extends Comparable<E>> implements OurQueue<E> {
	private Node first;
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public E element() {
		if (first == null){
			throw new NoSuchElementException();
		}
		return first.item;
	}

	@Override
	public void add(E item) {
		if(first == null || item.compareTo(first.item) < 0) {
			first = new Node(item, first);
			size++;
		} else {
			Node current = first;
			while (current.next != null &&
					item.compareTo(current.next.item) >= 0){
				current = current.next;
			}
			
			current.next = new Node(item, current.next);
			size++;
		}
		

	}

	@Override
	public E remove() {
		if (first == null){
			throw new NoSuchElementException();
		}
		size--;
		E output = first.item;
		first = first.next;
		return output;
		
	}

	@Override
	public void clear() {
		first = null;
		size = 0;

	}
	
	@Override
	public Iterator<E> iterator() {
		return new PriorityQueueIterator();
	}

	private class Node {
		public E item;
		public Node next;

		public Node(E newItem, Node nextNode) {
			item = newItem;
			next = nextNode;
		}

	}

	private class PriorityQueueIterator implements Iterator<E> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (current == null) throw new NoSuchElementException();
			E item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}

