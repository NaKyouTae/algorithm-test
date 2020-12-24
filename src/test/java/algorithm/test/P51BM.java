package algorithm.test;

import org.junit.Test;

public class P51BM {
	@Test
	public void test() {
		String t = "abcxdezcabacabac";
		String p = "abac";
		
		System.out.println(boyerMoore(t, p));
	}
	
	public int boyerMoore(String t, String p) {
		int pt = 0;
		int pp = 0;
		int tl = t.length();
		int pl = p.length();
		int[] s = new int[Character.MAX_VALUE + 1];
		
		
		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
			s[pt] = pl;
		}
		for(pt = 0; pt < pl-1; pt++) {
			s[p.charAt(pt)] = pl - pt - 1;
		}
		
		while(pt < tl) {
			pp = pl - 1;
			while(t.charAt(pt) == p.charAt(pp)) {
				System.out.println(t);
				dispD(pt-pp, false);
				dispSpace(pt-pp);
				System.out.println(p);
				if(pp == 0) {
					return pt;
				}
				pp--;
				pt--;
				
				
			}
			pt += (s[t.charAt(pt)] > pl - pp) ? s[t.charAt(pt)]:pl - pp;
		}
		
		return -1;
	}
	
	public void dispSpace(int n) {
		for(int i = 0; i < n; i++) {
			System.out.printf(" ");
		}
	}
	public void dispD(int n, boolean f) {
		dispSpace(n);
		System.out.printf(f == true ? "+":"|");
		System.out.println();
		
	}
}
