import java.util.*;
import java.io.*;
class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(0); return;
		}
		int[] xarr = new int[n];
		int[] yarr = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xarr[i] = Integer.parseInt(st.nextToken());
			yarr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xarr); Arrays.sort(yarr);
		System.out.println(Math.abs(xarr[n-1]-xarr[0])*Math.abs(yarr[n-1]-yarr[0]));
		
	}
}
