package algorithm.test;

import org.junit.Test;

public class P34 {
	@Test
	public void test() {
		int[] a = {1, 3, 9, 4, 7, 8, 6};
		
		buble1(a);
		print(a);
	}
	
	public void buble1(int[] a) {
		int x = 0;
		for(int i = 0; i < a.length-1; i++) {
			int ex = 0;
			for(int j = a.length-1; j > i; j--) {
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					System.out.println(x++);
					ex++; 
				}
			}
			if(ex ==0) break;
		}
	}
	
	public void buble(int[] a) {
		int x = 0;
		int k = 0;
		int n = a.length;
		while(k < n - 1) {
			int last = n - 1;
			for(int j = n - 1; j > k; j--) {
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					last = j;
					System.out.println(x++);
				}
			}
			k = last;
		}
	}
	
	public void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	public void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
