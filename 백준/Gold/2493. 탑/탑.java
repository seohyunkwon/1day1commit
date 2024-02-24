import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] result = new int[N];
        result[0] = -1;
        for(int i = 1; i < N; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && towers[stack.peek()] <= towers[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(i);

        }

        for(int i : result) {
            System.out.print(i + 1 + " ");
        }


    }
}
