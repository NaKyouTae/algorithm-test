package algorithm.test.algorithm.dp;

import java.util.Scanner;

//7
//35

//https://www.acmicpc.net/problem/1913

public class 달팽이배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		
		int[][] map = new int[n+1][n+1];
		boolean[][] visit = new boolean[n+1][n+1];
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int idx = 0;
		int cnt = n*n;
		for(int i = 1; i <= n/2; i++) {
			int x = i;
			int y = i;
			
			while(idx < 4) {
				
				int xx = x + dx[idx], yy = y + dy[idx];
				
				if(xx < i || yy < i || xx > n-i+1 || yy > n-i+1 || visit[x][y]) {
					idx++;
				}else {
						visit[x][y] = true;
						map[x][y] = cnt--;
						x = xx;
						y = yy;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int x = 0, y = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				int val = map[i][j];
				if(map[i][j] == t) {
					x = i;
					y = j;
				}
				sb.append(val).append(" ");
			}
			sb.append("\n");
		}
		
		sb.append(x).append(" ").append(y);
		
		System.out.println(sb.toString());
	}
}
