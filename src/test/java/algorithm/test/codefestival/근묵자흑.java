package algorithm.test.codefestival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 근묵자흑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		List<Integer> list = new ArrayList<>();
		int totMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			list.add(val);
			if(totMin > val) totMin = val;
		}
		
		int cnt = 0;
		while(true) {
			cnt++;
			
			for (int i = 0; i < list.size(); i += m) {
				int min = Integer.MAX_VALUE;
				if(i > list.size())i = (list.size()-1) - m;
				int len = ((i + m) > list.size()) ? list.size():(i+m);
				for (int j = i; j < len; j++) {
					if(min > list.get(j)) min = list.get(j);
				}
				for (int j = i; j < len; j++) {
					list.set(j, min); 
				}
			}
			
			boolean isMin = true;
			for (Integer l : list) {
				if(totMin != l) isMin = false;
			}
			
			if(isMin) break;
		}
		
		System.out.println("Hello Goorm! Your input is " + cnt);
	}
}
