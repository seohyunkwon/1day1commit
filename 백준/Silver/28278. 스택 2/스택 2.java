import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.equals("4")) {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			} else if (str.equals("2")) {
				sb.append(stack.isEmpty()?-1:stack.pop()).append("\n");
			} else if (str.equals("3")) {
				sb.append(stack.size()).append("\n");;
			} else if (str.equals("5")) {
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");;
			} else {
				String[] arr = str.split(" ");
				stack.add(Integer.parseInt(arr[1]));
			}
		}

		System.out.println(sb);

	}
}
