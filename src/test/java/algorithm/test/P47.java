package algorithm.test;

import org.junit.Test;

import algorithm.test.model.GSet;

public class P47 {
	@Test
	public void test() {
		GSet<Integer> g = new GSet<>(40);
		
		g.add(30);
		g.add(31);
		g.add(32);
		g.add(33);
		g.add(34);
		g.add(35);
		g.add(36);
		
		System.out.println("g : " + g.toString());
		
		GSet<Integer> t = new GSet<>(20);
		t.add(12);
		t.add(13);
		t.add(14);
		t.add(15);
		t.add(16);
		
		System.out.println("t : " + t.toString());
		
		GSet<Integer> u = new GSet<>((g.size() + t.size()));
		
		u.unionOf(g, t);
		
		System.out.println("u : " + u.toString());
		
		
		u.retain(g);
		System.out.println("u : " + u.toString());
		System.out.println("u max : " + u.capacity());
		
		
	}
}
