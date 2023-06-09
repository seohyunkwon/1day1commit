import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = new StringBuilder(st.nextToken()).reverse().toString();
        int b = Integer.parseInt(st.nextToken());
        int num = s.length()-1;
        long total = 0;
        for(int i=num; i>=0; i--){
            int n = 0;
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<10){
                n = s.charAt(i)-'0';
            } else {
                n = s.charAt(i)-'A'+10;
            }
            total+= (long)Math.pow(b,i)*n;
        }
        System.out.println(total);
    }
}
