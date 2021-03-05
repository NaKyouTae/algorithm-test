package algorithm.test.algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

public class DFS_HamburgerDiet {
	public static int limit, max;

	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		
		for(int p = 0; p < l; p++) {
			
			int number = sc.nextInt();
			limit = sc.nextInt();
			
			int[] pList = new int[number];
			int[] cList = new int[number];
			
			for(int i = 0; i < number; i++) {
				int point = sc.nextInt();
				int calorie = sc.nextInt();
				
				pList[i] = point;
				cList[i] = calorie;
			}
			max = 0;
			DFS(pList, cList, 0, 0, 0);
			System.out.println("#"+(p+1)+" "+max);			
		}
	}
	
	public static void DFS(int[] pList, int[] cList, int idx, int point, int calorie) {
		if(calorie > limit) return;
		if(idx == pList.length) {
			max = Math.max(max, point);
			return;
		}
		
		DFS(pList, cList, idx+1, point, calorie);
		DFS(pList, cList, idx+1, point+pList[idx], calorie+cList[idx]);
	}
}