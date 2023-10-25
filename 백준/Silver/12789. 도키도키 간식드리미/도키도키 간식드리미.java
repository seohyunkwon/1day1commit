import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        while(st.hasMoreTokens()){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> stack = new Stack<>();

        int rank = 1;

        loop:
        while(true){
            if(rank>n){
                System.out.println("Nice");
                break;
            }
            int a = queue.isEmpty()?-1:queue.peek();
            int b = stack.isEmpty()?-1:stack.peek();
            if(a==rank){
                queue.poll(); rank++;
                continue;
            }
            if(b==rank){
                stack.pop(); rank++;
                continue;
            }
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                if(tmp == rank){
                    rank++;
                    continue loop;
                } else {
                    stack.add(tmp);
                }
            }
            System.out.println("Sad");
            break;
        }
    }
}
