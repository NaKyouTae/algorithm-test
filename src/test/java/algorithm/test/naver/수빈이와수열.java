package algorithm.test.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수빈이와수열 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	list.add(Integer.parseInt(st.nextToken()) * (i+1));
        }
        
        sb.append(list.get(0)).append(" ");
        
        for(int i = 1; i < n; i++) {
            sb.append(list.get(i) - list.get(i-1)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
