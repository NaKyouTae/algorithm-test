package algorithm.test.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//5 5
//00011
//01011
//00110
//00001
//10100
//1 1
//5 5
//5 2

//https://www.acmicpc.net/problem/16469
public class 소년점프 {
	public static int[][] arr, brr;
	public static boolean[][] visit;
	public static int X, Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		
		arr = new int[X][Y];
		brr = new int[X][Y];
		visit = new boolean[X][Y];
		
		for(int i = 0; i < X; i++) {
			String s = br.readLine();
			for (int j = 0; j < Y; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		for(int i = 0; i < 3; i++) {
			String[] location = br.readLine().split(" ");
			int n = Integer.parseInt(location[0])-1;
			int m = Integer.parseInt(location[1])-1;
			visit[n][m] = true;
			dfs(n, m);
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				int val = brr[i][j];
				if(val < min && val != 0) {
					min = val;
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				int val = brr[i][j];
				if(val == min) {
					cnt++;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(min).append("\n");
		sb.append(cnt);
		
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
	
	public static void dfs(int n, int m) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		for(int i = 0; i < 4; i++) {
			int xx = n + dx[i], yy = m + dy[i];
			if(xx < X && yy < Y && xx >= 0 && yy >= 0) {
				if(!visit[xx][yy] && arr[xx][yy] != 1) {
					visit[xx][yy] = true;
					brr[xx][yy]++;
					dfs(xx, yy);
				}
			}
		}
	}
}
