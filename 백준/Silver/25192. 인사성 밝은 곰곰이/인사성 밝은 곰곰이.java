import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        int cnt = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.equals("ENTER")){
                if(set.isEmpty()) flag = true;
                else set = new HashSet<>();
            } else if(flag){
                if(!set.contains(s)){
                   cnt++; set.add(s);
                }
            }
        }
        System.out.println(cnt);
    }
}