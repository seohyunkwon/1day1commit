import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = Stream.of(input).mapToInt(Integer::parseInt).sorted().toArray();
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum-arr[arr.length-1]);
	}
}
