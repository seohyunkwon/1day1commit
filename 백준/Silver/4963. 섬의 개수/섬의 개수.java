import java.io.*;
import java.util.*;
class Main{
	static int[][] map;
	static int n,m;
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int[] dy = {-1,1,0,0,-1,1,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int cnt = 0;
			String s = br.readLine();
			if(s.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					boolean b = dfs(i, j);
					if(b) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static boolean dfs(int x, int y) {
		if(x<0 || y<0 || x>=m || y>=n) return false;
		if(map[x][y]==1) {
			map[x][y]=0;
			for(int i=0; i<dx.length; i++) {
				dfs(x+dx[i], y+dy[i]);
			}
			return true;
		}
		
		return false;
	}
}