import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long cnt = 0;
		long sum = 0;
		Map<Long, Long> map = new HashMap<Long, Long>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			sum+=Long.parseLong(st.nextToken());
			if(sum==k) cnt++;
			if(map.containsKey(sum-k)) {
				cnt+=map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, (long) 0)+1);
		}
		System.out.println(cnt);
	}
}