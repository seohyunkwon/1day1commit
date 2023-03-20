import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			map.put(i, Integer.parseInt(st.nextToken()));
		}
		
		TreeSet<Integer> set = new TreeSet<Integer>(map.values());
		int[] arr= new int[set.size()];
		int j=0;
		for(int i:set) {
			arr[j++]=i;
		}
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			sb.append(Arrays.binarySearch(arr,map.get(i))).append(' ');
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}