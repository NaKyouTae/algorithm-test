package algorithm.test.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//4
//5 45
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 -45
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 135
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 360
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25

//11 2 1 4 3 
//6 12 7 8 10 
//21 17 13 9 5 
//16 18 19 14 20 
//23 22 25 24 15 
//3 2 5 4 15 
//6 8 9 14 10 
//1 7 13 19 25 
//16 12 17 18 20 
//11 22 21 24 23 
//23 2 21 4 11 
//6 18 17 12 10 
//25 19 13 7 1 
//16 14 9 8 20 
//15 22 5 24 3 
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15 
//16 17 18 19 20
//21 22 23 24 25

//https://www.acmicpc.net/problem/17276

public class 배열돌리기_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int z = 0; z < t; z++) {
			String[] str = br.readLine().split(" ");
			
			int n = Integer.parseInt(str[0]);
			int c = Integer.parseInt(str[1]);
			
			int[][] map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int r = c/45;
			if(r > 0) {
				
			}else {
				
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			bw.write(sb.toString());
		}
		
		bw.flush();
		bw.close();
	}
}
