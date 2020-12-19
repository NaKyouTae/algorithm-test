package algorithm.test;

import org.junit.Test;

/**
 * @author nkt
 * 2020-12-19 heapSort 해야함
 */
public class P44 {
	@Test
	public void test() {
		int[] a = {10, 7, 5, 4, 1, 2, 8, 6, 9, 3};
		heapSort(a);
		for(int i = 0 ; i<a.length; i++)
			System.out.print(a[i]+",");
	}
	
	public void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	public void heapSort(int[] a) {
		int n = a.length;
		for(int i = (n - 1)/2; i >= 0; i--) {
			System.out.println("i : " + i);
			downHeap(a, i, n-1);
		}
		
		for(int i = n -1; i > 0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}
	
	public void downHeap(int[] a, int left, int right) {
		int t = a[left];
		int c;
		int p;
		
		for(p = left; p < (right + 1)/2; p = c) {
			int cl = p * 2 + 1;
			int cr = cl + 1;
			System.out.printf("left : %d, right : %d", cl, cr);
			c = (cr <= right && a[cr] > a[cl]) ? cr : cl;

			if(t >= a[c]) {
				break;
			}
			a[p] = a[c];
		}
		a[p] = t;
	}
}
