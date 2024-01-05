import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 sc.nextLine();
        loop :
		 for(int test_case=0; test_case<T; test_case++) {
			 sc.nextLine();
			 Map<Integer, Integer> map = new HashMap<>();
			 int[] arr = Arrays.stream(sc.nextLine().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
			 for(int i=0; i<arr.length; i++) {
				 map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			 }
			 
			 int max = Integer.MIN_VALUE;
			 Iterator<Integer> it = map.values().iterator();
			 while(it.hasNext()) {
				 max = Math.max(max, it.next());
			 }
			 
			 Integer[] keys = map.keySet().toArray(new Integer[0]);
			 Arrays.sort(keys, Collections.reverseOrder());
			 for(int i=0; i<keys.length; i++) {
				 if(map.get(keys[i])==max) {
					 System.out.printf("#%d %d\n", test_case+1,keys[i]);
					 continue loop;
				 }
			 }
		 }
	}
}
