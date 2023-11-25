import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        Stack<Boolean> isFirst = new Stack<>();
        for(int i=0; i<n; i++){
            String command = br.readLine();
            if(command.startsWith("1")){
                deque.addLast(command.split(" ")[1]);
                isFirst.add(false);
            }
            if(command.startsWith("2")){
                deque.addFirst(command.split(" ")[1]);
                isFirst.add(true);
            }
            if(command.startsWith("3")){
                if(deque.isEmpty()) continue;
                if(isFirst.pop()) deque.pollFirst();
                else deque.pollLast();
            }
        }
        if(deque.isEmpty()) System.out.println(0);
        else System.out.println(deque.stream().collect(Collectors.joining()));
    }
}
