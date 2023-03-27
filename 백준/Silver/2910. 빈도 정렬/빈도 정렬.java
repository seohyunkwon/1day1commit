import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer[]> map = new HashMap<>();
		int k=1;
		while(st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				map.put(key, new Integer[]{map.get(key)[0],map.get(key)[1]+=1});
			} else {
				map.put(key, new Integer[] {k++,1});
			}
		}
		List<Integer[]> list = new ArrayList<Integer[]>(map.values());
		Collections.sort(list,new Comparator<Integer[]>() {
			public int compare(Integer[] arr1, Integer[] arr2) {
				if(arr1[1]!=arr2[1]) return arr2[1]-arr1[1];
				else return arr1[0]-arr2[0];
			}
		});
		List<Integer> list2 = new ArrayList<Integer>(map.keySet());
		for(Integer[] arr: list) {
			for(int i:list2) {
				if(arr[0]==map.get(i)[0] && arr[1]==map.get(i)[1]) {
					for(int j=0; j<map.get(i)[1]; j++) {
						sb.append(i).append(' ');
					}
				}
			}
		}
		System.out.println(sb);
	
	}
}