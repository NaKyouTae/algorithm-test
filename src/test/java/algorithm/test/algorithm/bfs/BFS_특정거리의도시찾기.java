package algorithm.test.algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_특정거리의도시찾기 {
	public static int[][] arr;
	public static int[] brr;
	public static int N, M, D, S;
	public static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
				
		
		arr = new int[N][N];
		brr = new int[N];
				
		for (int i = 0; i < M; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0])-1;
			int y = Integer.parseInt(str[1])-1;
			list.get(x).add(y);
		}
		
		BFS();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if(brr[i] == D) {
				list.add(i+1);
			}
		}
		
		long cnt = list.stream().count();
		
		if(cnt == 0) {
			sb.append("-1");
		}else {
			for (Integer l : list) {
				sb.append(l).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void BFS() {
		Queue<Integer> que = new LinkedList<>();
		que.add(S-1);
		
		while(!que.isEmpty()) {
			int x = que.poll();
			for (int i = 0; i < list.get(x).size(); i++) {
				int next = list.get(x).get(i);
				System.out.println(next);
				if(brr[next] == 0) {
					brr[next] = brr[x] + 1;
					que.add(next);
				}
			}
		}
	}
}
