import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int cnt=0;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n+1][n+1];
    	for(int i=1; i<=n; i++) {
    		String s = br.readLine();
    		for(int j=1; j<=n; j++) {
    			arr[i][j] = s.charAt(j-1)-'0';
    		}
    	}
    	ArrayList<Integer> countArr = new ArrayList<Integer>();
    	int idx = 0;
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n; j++) {
    			if(dfs(i, j)) {
    				if(cnt>0) {
    					countArr.add(cnt);
    					idx++;
    					cnt = 0;
    				}
    			}
    		}
    	}
    	Collections.sort(countArr);
    	System.out.println(idx);
    	for(int i:countArr) {
    		System.out.println(i);
    	}
	}

    public static boolean dfs(int x, int y) {
    	if(x<0 || y<0 || x>n || y>n) {
    		return false;
    	}
    	if(arr[x][y]==1) {
    		cnt++;
    		arr[x][y]=0;
    		dfs(x-1, y);
    		dfs(x, y-1);
    		dfs(x+1, y);
    		dfs(x, y+1);
    		return true;
    	}
    	return false;
    }
}
