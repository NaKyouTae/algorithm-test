package algorithm.test.algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BFS_모래성쌓기 {
	public static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static String[][] arr;
	public static int[][] brr;
	public static boolean[][] visit;
	public static int[][] visit2;
	public static Queue<Node> que = new LinkedList<>();
	public static int x, y;
	
	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int e = Integer.parseInt(br.readLine());
		
		for (int p = 0; p < e; p++) {
			
			String[] str = br.readLine().split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			
			arr = new String[x][y];
			visit = new boolean[x][y];
			
			for (int i = 0; i < x; i++) {
				String s = br.readLine();
				for (int j = 0; j < y; j++) {
					arr[i][j] = String.valueOf(s.charAt(j));
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					String value = arr[i][j];
					if(!visit[i][j] && !value.equals(".") && !value.equals("9")) {
						brr = new int[x][y];
						visit2 = new int[x][y];
						visit[i][j] = true;
						que.add(new Node(i, j));
						BFS(i, j);
						cnt++;
						
						for (int k = 0; k < x; k++) {
							for (int k2 = 0; k2 < y; k2++) {
								String value2 = arr[k][k2];
								if(!value2.equals(".") && !value2.equals("9")) {
									if(Integer.parseInt(value2) <= brr[k][k2]) {
										arr[k][k2] = ".";
									}
								}
							}
						}
					}
				}
			}

			sb.append("#").append(p+1).append(" ").append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void BFS(int s, int e) {
		int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			int h = node.x;
			int w = node.y;
			
			for (int i = 0; i < 8; i++) {
				int xx = dx[i] + h, yy = dy[i] + w;
				if(xx < x && yy < y && xx >= 0 && yy >= 0) {
					String value = arr[xx][yy];
					if(value.equals(".")) {
						visit2[xx][yy] = visit2[xx][yy] + 1;
						brr[h][w] = brr[h][w] + 1;
					}else if(visit2[xx][yy] == 0 && !value.equals("9")){
						visit2[xx][yy] = visit2[xx][yy] + 1;
						que.add(new Node(xx, yy));
					}
				}
			}
		}
	}
}
