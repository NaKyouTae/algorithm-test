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

public class test {
	public static int[][] arr;
    public static int[] brr;
    public static int N, M, D, S;
    public static Queue<Integer> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            
            arr[x][y] = 1;
        }
        
        BFS();
        
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < brr.length; i++) {
            if(brr[i] == D) {
                list.add(i+1);
                cnt++;
            }
        }
        
        if(cnt == 0) {
            sb.append("-1");
        }else {
            for(Integer l : list) {
                sb.append(l).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static void BFS() {
        que.add(S-1);
        
        while(!que.isEmpty()) {
            int x = que.poll();
            for(int i = 0; i < arr.length; i++) {
                if(arr[x][i] == 1 && brr[i] == 0) {
                    brr[i] = brr[x] + 1;
                    que.add(i);
                }
            }
        }
    }
}
