package algorithm.test.solved;

import org.junit.Test;

import algorithm.test.model.GStack;

public class P27 {
	@Test
	public void test() {
		recur(4);
	}
	
	public void recur(int n) {
		GStack<Integer> stk = new GStack<>(n);
		
		while(true) {
			
			if(n > 0) {
				stk.push(n);
				n = n - 1;
				continue;
			}
			if(!stk.isEmpty()) {
				n = stk.pop();
				System.out.print(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}
}
