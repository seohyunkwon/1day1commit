import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.add(i);
        }
        int cnt = 0;
        for(int i:arr){
            if(deque.peek()==i){
                deque.poll();
                continue;
            }
            int idx = deque.indexOf(new Integer(i));
            if(Math.abs(idx-1)<Math.abs(idx-(deque.size()-1))){
                while(deque.peek()!=i){
                    deque.add(deque.poll());
                    cnt++;
                }
                deque.poll();
            } else {
                while(deque.peek()!=i){
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
                deque.poll();
            }
        }
        System.out.println(cnt);

    }
}
