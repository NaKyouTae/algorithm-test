package algorithm.test.algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class DFS_BackTracking_HamburgerDiet_ing2 {
	
	public static int max;
	public static int cnt;
	public static int limit;
	public static List<Integer> list = new ArrayList<>();
	
	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int l = 0; l < n; l++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			cnt = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			int[] calList = new int[cnt];
			int[] poinList = new int[cnt];
			for(int i = 0; i < cnt; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
				int p = Integer.parseInt(st1.nextToken());
				int cal = Integer.parseInt(st1.nextToken());
				
				calList[i] = cal;
				poinList[i] = p;
			}
			
				DFS(0, calList, poinList, calList[0], poinList[0]);
			
		}
		
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
	}
	
	public void DFS(int idx, int[] cList, int[] pList, int cal, int point) {
		if(idx == cnt) return;
		if(cal >= limit) return;
		if(max < point) {
			max = point;
			list.add(max);
		}
		DFS(idx+1, cList, pList, cal, point);
		DFS(idx+1, cList, pList, cal+cList[idx], point+pList[idx]);
	}
}
