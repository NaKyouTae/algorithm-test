package algorithm.test.solved;

import org.junit.Test;

import algorithm.test.model.ArrayQueue;

public class P21 {
	@Test
	public void test() {
		ArrayQueue<Integer> que = new ArrayQueue<>(50);
		
		
		que.enque(1);
		que.enque(2);
		que.enque(3);
		que.enque(4);
		
		que.dump();
		que.deque();
		System.out.println();
		que.dump();
		
		que.enque(9);
		que.deque();
		que.deque();
		
		System.out.println();
		que.dump();
	}
}
