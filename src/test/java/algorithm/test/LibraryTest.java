package algorithm.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class LibraryTest {
	public static int[] arr;
	public static boolean[] visit;
	public static int last;
	public static List<Integer> list = new ArrayList<>();
	
    @Test
    public void test() throws IOException {
//5
//6 8 2 6 2
//3 2 3 4 6
//6 7 3 3 2
//7 2 5 3 6
//8 9 5 2 7
    	run();
    }
    
    public void run() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int l = Integer.parseInt(br.readLine());
    	
    	arr = new int[l];
    	visit = new boolean[l];
    	
    	for(int i = 0; i < l; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		visit[i] = true;
    		last = i+1;
    		DFS(i);
    		visit[i] = false;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(list.size()).append("\n");
    	
    	list.stream().sorted().forEach(item -> {
    		sb.append(item).append("\n");
    	});
    	
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
	}
    
    public static void DFS(int i) {
    	int idx = arr[i]-1;
    	
    	if(!visit[idx]) {
    		visit[idx] = true;
    		DFS(idx);
    		visit[idx] = false;
    	}
    	
    	if(arr[i] == last) {
    		list.add(last);
    	}
    }
    
}
