import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String[] arr = br.readLine().split("");
		st = new StringTokenizer(br.readLine());
		int[] cnt = new int[4];
		for(int i=0; i<cnt.length; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int[] window = new int[4];
		for(int i=0; i<p; i++) {
			if(arr[i].equals("A")) window[0]++;
			else if(arr[i].equals("C")) window[1]++;
			else if(arr[i].equals("G")) window[2]++;
			else if(arr[i].equals("T")) window[3]++;
		}
		for(int i=0; i<4; i++) {
			if(window[i]<cnt[i]) break;
			if(i==3) result++;
		}
		for(int i=1; i<s-p+1; i++) {

			if(arr[i-1].equals("A")) window[0]--;
			else if(arr[i-1].equals("C")) window[1]--;
			else if(arr[i-1].equals("G")) window[2]--;
			else if(arr[i-1].equals("T")) window[3]--;
			
			if(arr[i+p-1].equals("A")) window[0]++;
			else if(arr[i+p-1].equals("C")) window[1]++;
			else if(arr[i+p-1].equals("G")) window[2]++;
			else if(arr[i+p-1].equals("T")) window[3]++;
			
			
			for(int j=0; j<4; j++) {
				if(window[j]<cnt[j]) {
					break;
				}
				if(j==3) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
