import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 구간합 맵 만들기
		int[][] map = new int[n+1][n+1];
		int[][] prepix = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=1; j<n+1; j++) {
				map[i][j] = arr[j-1];
				prepix[i][j] = prepix[i][j-1]+prepix[i-1][j]-prepix[i-1][j-1]+arr[j-1];
			}
		}
		// m만큼 실행
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = prepix[x2][y2]-prepix[x2][y1-1]-prepix[x1-1][y2]+prepix[x1-1][y1-1];
			System.out.println(result);
		}
	
	}
}