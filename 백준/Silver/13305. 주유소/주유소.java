import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dis = new int[n-1];
		int[] pri = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<dis.length; i++) {
			dis[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<pri.length; i++) {
			pri[i]=Integer.parseInt(st.nextToken());
		}
		long result = pri[0]*dis[0]; int price = pri[0]>pri[1]?pri[1]:pri[0];
		for(int i=1; i<dis.length; i++) {
			result+=price*dis[i];
			if(pri[i]>pri[i+1]) {
				price=pri[i+1];
			} else {
				price=pri[i];
			}
			
		}
		System.out.println(result);
	
	}
}