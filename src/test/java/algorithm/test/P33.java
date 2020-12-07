package algorithm.test;

import org.junit.Test;

public class P33 {
	private String str = "";
	@Test
	public void test() {
		int[] a = {6,4,3,7,1,9,8};
		buble(a);
	}
	
	public void buble(int[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length -  1; j++) {
				if(a[j+1] < a[j]) {
					swap(a, j+1, j);
					System.out.printf("%d%s", a[j], "+");
				}else {
					System.out.printf("%d%s", a[j], "-");
				}
			}
			System.out.println();
		}
	}
	
	public void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
