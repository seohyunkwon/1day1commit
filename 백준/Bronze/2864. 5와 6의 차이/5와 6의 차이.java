import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr1 = s.replaceAll("5", "6").split(" ");
		String[] arr2 = s.replaceAll("6", "5").split(" ");
		int max = Stream.of(arr1).mapToInt(Integer::parseInt).sum();
		int min = Stream.of(arr2).mapToInt(Integer::parseInt).sum();
		System.out.println(min +" "+max);
	}
}