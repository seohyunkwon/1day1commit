import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = arr[0];
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(start<=end) {
			if(sum<s) {
				end++;
				if(end>=n) break;
				sum+=arr[end];
			} else if(sum>=s) {
				list.add(end-start+1);
				sum-=arr[start];
				start++;
			} else {
				list.add(end-start+1);
				return;
			}
		}
		if(list.isEmpty()) System.out.println(0);
		else System.out.println(Collections.min(list));
	}
}