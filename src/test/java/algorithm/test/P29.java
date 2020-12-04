package algorithm.test;

import org.junit.Test;

import algorithm.test.model.GStack;

public class P29 {

	@Test
	public void test() {
		move(3, 1, 3);
	}
	
	public void move(int n, int x, int y) {
		if(n > 1)
			move(n-1, x, 6 - x - y);
		
		System.out.println("n["+n+"] 은 "+ (x == 1 ? "A기둥":x == 2 ? "B기둥":"C기둥") +"에서 " + (y == 1 ? "A기둥":y == 2 ? "B기둥":"C기둥") +"로 이동하였습니다.");
		
		if(n > 1)
			move(n-1, 6 - x - y, y);
	}
	
	public void move1(int n, int x, int y) {
		GStack<Integer> stk = new GStack<>(n);
		
		if(n > 0) {
			stk.push(n);
			n = n - 1;
		}
			
		System.out.println("n["+n+"] 은 "+ (x == 1 ? "A기둥":x == 2 ? "B기둥":"C기둥") +"에서 " + (y == 1 ? "A기둥":y == 2 ? "B기둥":"C기둥") +"로 이동하였습니다.");
			
		if(n > 1) {
			
		}
		
		
	}
}
