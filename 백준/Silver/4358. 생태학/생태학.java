import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		while(sc.hasNext()) {
			String s =sc.nextLine();
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			} else map.put(s, 1);
		}
		List<Integer> list = new ArrayList<Integer>(map.values());
		double sum=0;
		for(int i:list) {
			sum+=i;
		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String ratio = String.format("%.4f", 100*map.get(key)/sum);
			System.out.println(key+" "+ratio);
			
		}
	}
}
