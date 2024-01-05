import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int plus = arr[i][j];
					int multi = arr[i][j];
					for(int k = 1; k<M; k++) {
						if(i-k >= 0) plus += arr[i-k][j];
						if(j-k >= 0) plus += arr[i][j-k];
						if(i+k < N) plus += arr[i+k][j];
						if(j+k < N) plus += arr[i][j+k];
						
						if(i-k >= 0 && j-k >= 0) multi += arr[i-k][j-k];
						if(i-k >= 0 && j+k < N) multi += arr[i-k][j+k];
						if(j-k >= 0 && i+k < N) multi += arr[i+k][j-k];
						if(j+k < N && i+k < N) multi += arr[i+k][j+k];		
					}
					if(max < Math.max(plus, multi)) max = Math.max(plus, multi);  
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
