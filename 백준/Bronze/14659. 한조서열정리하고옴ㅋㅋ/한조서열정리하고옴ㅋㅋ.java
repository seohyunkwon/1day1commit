import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int prev = arr[0]; int cnt=0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>prev) {
				prev=arr[i];
				list.add(cnt);
				cnt=0;
			}
			else cnt++;
			
		}
		list.add(cnt);
		System.out.println(Collections.max(list));
	}
}
