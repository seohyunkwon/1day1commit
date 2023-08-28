
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		LinkedList<Integer> result = new LinkedList<Integer>();
		for(int i=n-1; i>=0; i--) {
			int tmp = arr[i];
			if(result.isEmpty()) {
				result.add(i+1);
			} else {
				result.add(tmp, i+1);				
			}
		}
		System.out.println(result.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
	}
}
