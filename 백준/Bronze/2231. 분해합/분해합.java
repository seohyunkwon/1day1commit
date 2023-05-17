import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        for(int i=1; i<n; i++){
           String s = String.valueOf(i);
           int tmp = i;
           for(int j=0; j<s.length(); j++){
               tmp+=s.charAt(j)-'0';
           }

           if(tmp==n) {
               System.out.println(i);
               return;
           }
        }
        System.out.println(0);
    }
}
