import java.util.NoSuchElementException;


public class TestPriorityQueue {
	public static void main(String [] args) {
		OurQueue<String> queue = new OurPriorityQueue<String>();
		System.out.println(queue.isEmpty()); // expect true
		System.out.println(queue.size()); // expect 0
		
		queue.add("kiwi");
		System.out.println(queue.isEmpty()); // expect false
		System.out.println(queue.size()); // expect 1
		System.out.println(queue.element()); // expect "kiwi"
		
		
		queue.add("apple");
	    queue.add("orange");
			
		// expect apple, kiwi, orange
		for (String fruit: queue) {
			System.out.println(fruit); 
	    }
	
		System.out.println(queue.isEmpty()); // expect false
		System.out.println(queue.size()); // expect 3
		System.out.println(queue.element()); // expect "apple"
		
		//OurQueue<Integer> intQueue = new OurPriorityQueue<Integer>();
		// Java 8 syntax:
		OurQueue<Integer> intQueue = new OurPriorityQueue<>();
		intQueue.add(7);
		intQueue.add(5);
		intQueue.add(10);
		System.out.println(intQueue.element()); // expect 5
		
		// expect 5, 7, 10
		for (int n: intQueue) {
			System.out.println(n); 		
		}
	}

}
