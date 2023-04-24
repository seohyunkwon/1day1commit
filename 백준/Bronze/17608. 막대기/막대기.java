import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int cnt = 1;

        for (int i = 0; i < N; i++) {
         stack.add(Integer.parseInt(br.readLine()));
        }

        int stick = stack.pop();

        int compare;
        
        while (!stack.isEmpty()) {
            compare = stack.pop();

            if(compare > stick) {
                stick = compare;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}