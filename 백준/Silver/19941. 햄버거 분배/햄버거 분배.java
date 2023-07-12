
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0;
		String s = br.readLine();
		boolean[] visited = new boolean[n];
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='H') continue;
			int start = i-k<0?0:i-k;
			int end = i+k>=n?n-1:i+k;
			for(int j = start; j<=end; j++) {
				if(s.charAt(j)=='P') continue;
				if(!visited[j]) {
					cnt++;
					visited[j] = true;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
