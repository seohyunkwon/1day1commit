import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> remain = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            int m = 0;
            while(m!=arr[i]) {
                remain.add(stack.pop());
                m++;
            }
            stack.add(i+1);
            while(!remain.isEmpty()) {
                stack.add(remain.pop());
            }
        }
        System.out.println(stack.toString()
                .replaceAll("\\[","")
                .replaceAll("]","")
                .replaceAll(",",""));
    }
}
