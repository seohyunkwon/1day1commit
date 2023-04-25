import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int result =0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]-arr[i]>=l) {
					result++;
					i = j-1;
					break;
				}
			}
			
		}
		result++;
		System.out.println(result);
	}
}

      