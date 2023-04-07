import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		int prev = 0; int cnt = 0;
		for(int i=0; i<n; i++) {
			if(prev==3) prev=0;
			if(arr[i]==prev) {
				prev++;
				cnt++;
			}
		}
		System.out.println(cnt);
	
	}
}
