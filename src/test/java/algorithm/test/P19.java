package algorithm.test;

import org.junit.Test;

public class P19 {
	@Test
	public void test() {
		Gstack<Integer> stk = new Gstack<Integer>(50);
		
		
		stk.push(1234);
		stk.push(234);
		stk.push(5435);
		stk.push(123);
		stk.push(5435);
		stk.push(7567);
		stk.push(59);
		stk.push(5435);
		
		stk.pop();
		
		stk.dump();
	}
	
	public static class EmptyStackException extends RuntimeException{
		public EmptyStackException() {
			System.out.println("스택이 비어 있습니다.");
		}
	}
	public static class OverflowStackException extends RuntimeException{
		public OverflowStackException() {
			System.out.println("스택이 가득 찼습니다.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static class Gstack<E> {
		private int max;
		private int ptr = 0;
		private E[] stk;
		
		Gstack(int size){
			this.stk = (E[]) new Object[size];
		}
		
		int size(){
			return ptr;
		}
		
		int capacity(){
			return max;
		}
		
		E push(E n) throws OverflowStackException{
			if(ptr >= max) throw new OverflowStackException();
			return stk[ptr++] = n; 
		}
		
		E pop() throws EmptyStackException{
			if(ptr <= 0) throw new EmptyStackException();
			return stk[--ptr];
		}
		
		E peek() throws EmptyStackException{
			if(ptr <= 0) throw new EmptyStackException();
			return stk[ptr-1];
		}
		
		void dump(){
			if(ptr <= 0) {
				System.out.println("스택이 비어 있습니다.");
			}else {
				for(int i = 0; i<ptr; i++) {
					System.out.println(stk[i]);
				}
			}
		}
	}
	
}
