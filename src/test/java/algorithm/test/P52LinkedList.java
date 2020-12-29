package algorithm.test;

import java.util.Comparator;

import org.junit.Test;

import algorithm.test.model.GLinkedList;

/**
 * @author nkt
 * P. 331 9-1
 *
 * Create by User Date : 2020. 12. 28.
 *
 */
public class P52LinkedList {
	@Test
	public void test() {
		GLinkedList<Integer> gl = new GLinkedList<>();
		
		gl.addLast(1);
		gl.addLast(2);
		gl.addLast(3);
		gl.addLast(4);
		gl.addLast(13);
		gl.addLast(6);
		gl.addLast(7);
		gl.addLast(8);
		gl.addLast(9);
		gl.addLast(10);
		gl.addLast(11);
		gl.addLast(12);
		gl.addLast(13);
		
		gl.dump();
		System.out.println();
		gl.purge(Order);
		gl.dump();
		
		gl.retrieve(3);
	}
	public static final Comparator<Integer> Order = new GComparator();
	private static class GComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer s, Integer t) {
			return (s > t) ? 1 : (s < t) ? -1 : 0;
		}
	}
	
	
}
