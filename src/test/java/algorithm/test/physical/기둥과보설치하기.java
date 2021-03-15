package algorithm.test.physical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/60061?language=java
public class 기둥과보설치하기 {
	public static void main(String[] args) {
		int n = 5;
//		int[][] arr = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] arr = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		run(n, arr);
	}
	
	public static class Node {
		int x;
		int y;
		int t;
		Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	public static List<Node> list = new ArrayList<>();
	public static Comparator<Node> compare = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return (o1.x == o2.x) ? (o1.y == o2.y) ? (o1.t == o2.t) ? 0:(o1.t > o2.t) ? 1:-1 :(o1.y > o2.y) ? 1:-1 : (o1.x > o2.x) ? 1:-1;
		}
	};
	public static void run(int n, int[][] build_frame) {
		
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int t = build_frame[i][2];
			int s = build_frame[i][3];
			
			if(s == 0) {
				list.remove(indexOf(x, y, t));
				if(!isPossible(x, y, t)) {
					list.add(new Node(x, y, t));
				}
			}else if(s == 1){
				list.add(new Node(x, y, t));
				if(!isPossible(x, y, t)) {
					list.remove(indexOf(x, y, t));
				}
			}
		}
		
		Collections.sort(list, compare);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print("{" + list.get(i).x + "," + list.get(i).y + "," + list.get(i).t + "},");
		}
	}
	
	public static boolean isPossible(int x, int y, int t) {
		if(t == 0) {
			if(y == 0 
			|| indexOf(x-1, y, 1) != -1
			|| indexOf(x, y, 1) != -1 
			|| indexOf(x, y-1, 0) != -1){
				return true;
			}else {
				return false;
			}
		}else if(t == 1){
			if(indexOf(x, y-1, 0) != -1
			|| indexOf(x+1, y-1, 0) != -1
			|| (indexOf(x-1, y, 1) != -1 
			&& indexOf(x+1, y, 1) != -1)){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public static int indexOf(int x, int y, int t) {
		int result = -1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).x == x && list.get(i).y == y && list.get(i).t == t) {
				result = i;
			}
		}
		
		return result;
	}
}
