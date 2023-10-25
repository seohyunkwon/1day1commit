import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb =  new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            switch (tmp[0]){
                case 1 : deque.addFirst(tmp[1]); break;
                case 2 : deque.addLast(tmp[1]); break;
                case 3 : sb.append(!deque.isEmpty()?deque.pollFirst():"-1").append("\n"); break;
                case 4 : sb.append(!deque.isEmpty()?deque.pollLast():"-1").append("\n"); break;
                case 5 : sb.append(deque.size()).append("\n"); break;
                case 6 : sb.append(deque.isEmpty()?"1":"0").append("\n"); break;
                case 7 : sb.append(!deque.isEmpty()?deque.peekFirst():"-1").append("\n"); break;
                case 8 : sb.append(!deque.isEmpty()?deque.peekLast():"-1").append("\n"); break;
            }
        }
        System.out.println(sb.toString());

    }
}
