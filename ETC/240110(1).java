import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				int[] tmp = Arrays.stream(br.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
				for(int j=0; j<N; j++) {
					arr[i][j] = tmp[j];
				}
			}
			System.out.printf("#%d\n", test_case);
			for(int i=0; i<arr.length; i++) {
				print(arr, i);
			}
			
		}
	}
	
	private static void print(int[][] arr, int idx) {
		StringBuffer sb = new StringBuffer();
		for(int i=arr.length-1; i>=0; i--) {
			sb.append(arr[i][idx]);
		}
		sb.append(" ");
		for(int i=arr.length-1; i>=0; i--) {
			sb.append(arr[arr.length-idx-1][i]);
		}
		sb.append(" ");
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i][arr.length-idx-1]);
		}
		System.out.println(sb);
	}
}
