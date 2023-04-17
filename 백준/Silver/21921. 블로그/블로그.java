import java.io.*;
import java.util.*;

import javax.security.auth.kerberos.KerberosKey;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=n; i>=x; i--) {
			int key = arr[i]-arr[i-x];
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else map.put(key,	1);
		}
		Iterator<Integer> it = map.keySet().iterator();
		int max = Integer.MIN_VALUE;
		while(it.hasNext()) {
			max = Math.max(max, it.next());
		}
		if(max==0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(map.get(max));
	
	}
}