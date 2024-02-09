import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] numbers = new int[N];
        int[] NGE = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);

        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                NGE[stack.pop()] = i;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            NGE[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int tmp : NGE) {
            sb.append((tmp==-1?-1:numbers[tmp])+" ");
        }

        System.out.println(sb.toString());

    }
}