package algorithm.test.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//3 1

//https://www.acmicpc.net/problem/15649
public class N과M1 {
	public static int N, L;
	public static int[] arr, res;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		
		arr = new int[N];
		res = new int[N];
		visit = new boolean[N];
		
		for(int i = 0;)
		
		if(L == 1) {
			for(int i = 1; i <= N; i++) {
				sb.append(i).append("\n");
			}
		}else {			
			for(int i = 1; i <= N; i++) {
				dfs(i);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	
	public static void dfs(int idx) {
		if(idx == N) {
			for(int i = 0; i < res.length; i++) {
				sb.append(i)
			}
			return;
		}
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[j] && idx != j+1) {
					visit[j] = true;
					sb.append(idx).append(" ").append(j+1).append("\n");
					dfs(idx + 1);
					visit[j] = false;
				}
			}
			sb.append("\n");
		}
	}
}
