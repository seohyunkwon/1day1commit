import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        LinkedList<Integer> s = new LinkedList<>();
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int n = 0;
            if(!str.equals("all") && !str.equals("empty"))
                n = Integer.parseInt(st.nextToken());

            switch (str){
                case "add" : if(!s.contains(new Integer(n))) s.add(n); break;
                case "remove" : if(s.contains(new Integer(n))) s.remove(new Integer(n)); break;
                case "check" : sb.append(s.contains(new Integer(n))?1+"\n":0+"\n"); break;
                case "toggle" : if(s.contains(new Integer(n))) s.remove(new Integer(n)); else s.add(n); break;
                case "all" : s.clear(); for(int j = 1; j<=20; j++){s.add(j);} break;
                case "empty" : s.clear(); break;
            }
        }
        System.out.println(sb);
    }
}
