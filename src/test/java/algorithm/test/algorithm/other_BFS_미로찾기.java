package algorithm.test.algorithm;

public class other_BFS_미로찾기 {
	/******************************************************************************

	Welcome to GDB Online.
	GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
	C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
	Code, Compile, Run and Debug online from anywhere in world.

	*******************************************************************************/
	import java.util.*;
	public class Main
	{
	    static class Node{
	        int r;
	        int c;
	        Node(int r, int c){
	            this.r = r;
	            this.c = c;
	        }
	    }
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int M = sc.nextInt();

	        int[][] map = new int[N][M];
	        int[][] check = new int[N][M];

	        for(int i=0; i<N; i++){
	            for(int j=0; j<M; j++){
	                map[i][j] = sc.nextInt();
	            }
	        }

	        Queue<Node> q = new LinkedList<>();
	        q.add(new Node(0,0));
	        check[0][0] = 1;

	        int[] dr = {1, -1, 0, 0};
	        int[] dc = {0, 0, -1, 1};

	        while(!q.isEmpty()){
	            Node buf = q.poll();

	            for(int d=0; d<4; d++){
	                int r = buf.r + dr[d];
	                int c = buf.c + dc[d];

	                if(r<0 || c<0 || r>=N||c>=M)
	                    continue;
	                
	                if(map[r][c] == 1 && check[r][c] == 0){
	                    check[r][c] = check[buf.r][buf.c] + 1;
	                    q.add(new Node(r,c));
	                }
	            }
	        }

	        System.out.println(check[N-1][M-1]);



	   }
	}
}
