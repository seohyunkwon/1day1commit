import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		int sum=0;
		Collections.sort(list);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:list) {
			if(map.containsKey(i)) map.put(i, map.get(i)+1);
			else map.put(i, 1);
			sum+=i;
		}
		int max=Collections.max(map.values());
		ArrayList<Integer> minlist = new ArrayList<Integer>();
		for(int i:map.keySet()) {
			if(map.get(i)==max) minlist.add(i);
		}
		Collections.sort(minlist);
		
		sb.append(Math.round(sum/(double)list.size())).append('\n');
		sb.append(list.get(list.size()/2)).append('\n');
		sb.append(minlist.size()>1?minlist.get(1):minlist.get(0)).append('\n');
		sb.append(Collections.max(list)-Collections.min(list)).append('\n');
		
		System.out.println(sb);
	}
}