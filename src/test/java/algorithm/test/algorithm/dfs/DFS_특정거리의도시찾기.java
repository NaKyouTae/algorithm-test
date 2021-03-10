package algorithm.test.algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DFS_특정거리의도시찾기 {
	
	public static int[][] brr;
	public static int[][] arr;
	public static boolean[] visit;
	public static int N, M, D, S;
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		brr = new int[N][N];
		arr = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			
			int x = Integer.parseInt(str[0])-1;
			int y = Integer.parseInt(str[1])-1;
			
			brr[x][y] = 1;
		}
		for (int i = S-1; i < N; i++) {
			visit = new boolean[N];
			DFS(i, i, 0);
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(arr[S-1][i] == D) {
				list.add(i+1);
				cnt++;
			}
		}
		
		if(cnt == 0) {
			sb.append("-1");
		}else {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int s, int idx, int cnt) {
		arr[s][idx] = cnt;
		visit[s] = true;
		
		for (int i = 0; i < N; i++) {
			int val = brr[idx][i];
			if(val == 1) {
				if(!visit[i]) {
					DFS(s, i, cnt+1);
				}
			}
		}
	}
}
