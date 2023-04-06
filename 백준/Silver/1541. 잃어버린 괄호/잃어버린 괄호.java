import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split("-");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String i:arr) {
			if(i.contains("+")) {
				String[] tmp = i.split("\\+");
				int sum = Arrays.stream(tmp).mapToInt(Integer::parseInt).sum();
				list.add(sum);
			} else list.add(Integer.parseInt(i));
		}
		long result = list.get(0);
		list.remove(0);
		for(int i:list) {
			result -=i;
		}
		System.out.println(result);
		
	}
}