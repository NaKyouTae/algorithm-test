package algorithm.test.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//2
//3
//911
//97625999
//91125426
//5
//113
//12340
//123440
//12345
//98346

//https://www.acmicpc.net/problem/5052
public class 전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int e = 0; e < T; e++) {
			int ca = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			list.add(br.readLine());
			
			String res = "YES";
			boolean isNo = false;
			for (int c = 1; c < ca; c++) {
				String v = br.readLine();
				for (int i = 0; i < v.length(); i++) {
					int idx = list.indexOf(v.substring(0, i));
					if(idx != -1 && list.get(idx).length() == v.substring(0, i).length()) {
						res = "NO";
						isNo = true;
						break;
					}
				}
				if(isNo) break;
				list.add(v);
			}
			
			sb.append(res).append("\n");
		}
		
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
