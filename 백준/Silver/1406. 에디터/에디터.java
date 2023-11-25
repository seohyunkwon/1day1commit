import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> remain = new Stack<>();
        Stack<String> store = new Stack<>();
        for(String s:str.split("")){
            remain.push(s);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String command = br.readLine();
            if(command.startsWith("L")) {
                if(remain.isEmpty()) continue;
                store.push(remain.pop());
            }
            if(command.startsWith("D")) {
                if(store.isEmpty()) continue;
                remain.push(store.pop());
            }
            if(command.startsWith("B")){
                if(remain.isEmpty()) continue;
                remain.pop();
            }
            if(command.startsWith("P")){
                String tmp = command.split(" ")[1];
                remain.push(tmp);
            }

        }
        while(!store.isEmpty()){
            remain.push(store.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!remain.isEmpty()){
            sb.append(remain.pop());
        }
        System.out.println(sb.reverse());
    }
}
