import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int j=0; j<T; j++) {
            char[] commands = br.readLine().toCharArray();
            Stack<Character> prev = new Stack<>();
            Stack<Character> post = new Stack<>();

            for(int i = 0; i < commands.length; i++) {
                if(commands[i] == '<') {
                    if(!prev.isEmpty()) post.push(prev.pop());
                } else if(commands[i] == '>') {
                    if(!post.isEmpty()) prev.push(post.pop());
                } else if(commands[i] == '-') {
                    if(!prev.isEmpty()) prev.pop();
                } else {
                    prev.push(commands[i]);
                }
            }
            StringBuilder sb = new StringBuilder();

            while(!prev.isEmpty()) {
                sb.append(prev.pop());
            }
            sb = sb.reverse();
            while(!post.isEmpty()) {
                sb.append(post.pop());
            }
            System.out.println(sb.toString());
        }
    }
}