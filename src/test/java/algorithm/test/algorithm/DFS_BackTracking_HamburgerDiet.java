package algorithm.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class DFS_BackTracking_HamburgerDiet {
	
	public static List<Integer> list = new ArrayList<>();
	public static int[] caloList;
	public static int[] poinList;
	public static boolean[] visit;
	public static int limit;
	public static int cal;
	public static int point;	
	public static int max;
	
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
			int cnt = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			visit = new boolean[cnt];
			
			caloList = new int[cnt];
			poinList = new int[cnt];
			
			for(int i = 0; i < cnt; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
				
				int point = Integer.parseInt(st1.nextToken());
				int cal = Integer.parseInt(st1.nextToken());
				
				caloList[i] = cal;
				poinList[i] = point;
			}
			
			for(int i = 0; i < cnt; i++) {
				visit[i] = true;
				DFS(i);
				visit[i] = false;
			}
			
			bw.write(Integer.toString(max));
			bw.flush();
			bw.close();
		}
	}
	
	public static void DFS(int idx) {
		
		cal += caloList[idx];
		point += poinList[idx];
		
		if(!visit[idx] && cal < limit) {			
			if(max < point) {
				max = point;
			}
			visit[idx] = true;
			DFS(idx+1);
			visit[idx] = false;
		}
	}
}
