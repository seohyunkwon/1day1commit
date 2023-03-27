import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		for(int i=0; i<n; i++) {
			String name = br.readLine();
			int k = Integer.parseInt(br.readLine());
			String[] arr = new String[k];
			for(int j=0; j<k; j++) {
				arr[j]=br.readLine();
			}
			map.put(name, arr);
		}
		for(int i=0; i<m; i++) {
			StringBuilder sb = new StringBuilder();
			String ans = br.readLine();
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				String[] arr=map.get(ans);
				Arrays.sort(arr);
				for(String s:arr) {
					System.out.println(s);
				}
			} else {
				ArrayList<String> list = new ArrayList<String>(map.keySet());
				for(String s:list) {
					String[] arr = map.get(s);
					for(String s2:arr) {
						if(s2.equals(ans)) {
							System.out.println(s);
						}
					}
				}
			}
		}
	}
}