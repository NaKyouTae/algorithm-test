package algorithm.test.study;


//최대 100만

//https://programmers.co.kr/learn/courses/30/lessons/12911

public class 다음큰수 {
	public static void main(String[] args) {
		int n = 15;
		int a = n;
		int nc = getCountByBinary(n);
		while(true) {
			int c = getCountByBinary(++a); 
			System.out.println(nc + " : " + c + " : " + a);
			if(nc == c) {
				System.out.println(a); 
				break;
			}
		}
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(a));
	}
	
	public static int getCountByBinary(int n) {
		int cnt = 0;
		while(n > 0) {
			int o = n%2;
			n/=2;
			if(o == 1) cnt++;
		}
		
		return cnt;
	}
}
