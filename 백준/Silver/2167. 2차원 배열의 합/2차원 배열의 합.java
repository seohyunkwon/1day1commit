import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<m+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				map[i][j] = map[i-1][j]+map[i][j-1]+map[i][j]-map[i-1][j-1];
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1  = Integer.parseInt(st.nextToken());
			int y1  = Integer.parseInt(st.nextToken());
			int x2  = Integer.parseInt(st.nextToken());
			int y2  = Integer.parseInt(st.nextToken());
			
			int result = map[x2][y2]-map[x1-1][y2]-map[x2][y1-1]+map[x1-1][y1-1];
			System.out.println(result);
			
		}
		
		
	}
}