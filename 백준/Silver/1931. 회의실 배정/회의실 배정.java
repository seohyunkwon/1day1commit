import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Integer[] {a,b});
		}
		Collections.sort(list, (a,b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
		int end = list.get(0)[1];
		int cnt = 1;
		for(int i=1; i<list.size(); i++) {
			Integer[] arr = list.get(i);
			if(arr[0]>=end) {
				end = arr[1];
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}