import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        while(n>0){
            int tmp = n%b;
            if(tmp<10) sb.append(tmp);
            else {
                sb.append((char)(tmp+55));
            }
            n/=b;
        }
        System.out.println(sb.reverse().toString());
    }
}
