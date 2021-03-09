package algorithm.test.algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class test {
	public static class Node {
    	int x;
        int y;
        Node(int x, int y) {
        	this.x = x;
            this.y = y;
        }
    }
    public static String[][] arr;
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int x, y;
    public static Queue<Node> que = new LinkedList<>();
        
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int p = 0; p < T; p++){
            String[] str = br.readLine().split(" ");
			
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			
			arr = new String[x][y];
			
			for (int i = 0; i < x; i++) {
				String s = br.readLine();
				for (int j = 0; j < y; j++) {
					arr[i][j] = String.valueOf(s.charAt(j));
					if(arr[i][j].equals(".")) {
						que.add(new Node(i, j));
					}
				}
			}
			
			int cnt = 0;
			
			while(!que.isEmpty()) {
				cnt++;
				int size = que.size();
				
				for (int i = 0; i < size; i++) {
					Node node = que.poll();
					
					for (int j = 0; j < 8; j++) {
						int xx = dx[j] + node.x, yy = dy[j] + node.y;
						if(xx < x && yy < y && xx >= 0 && yy >= 0) {
							String val = arr[xx][yy];
							if(!val.equals("9") && !val.equals(".") && !val.equals("0")) {
								int send = Integer.parseInt(arr[xx][yy]) -1;
								arr[xx][yy] = Integer.toString(send);
							}
							
							if(arr[xx][yy].equals("0")){
								que.add(new Node(xx, yy));
							}
						}
					}
				}
                				
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						if(arr[i][j].equals("0")) {
							arr[i][j] = ".";
						}
					}
				}
			}
			
			sb.append("#").append(p+1).append(" ").append(cnt-1).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
 	}
}
