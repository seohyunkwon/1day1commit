import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ns = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        if(n==0) {
            System.out.println(1);
            return;
        }
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rank = 1;
        int eqal = 0;
        for(int i=0; i< scores.length; i++){
           if(ns>scores[i]) break;
            else if(ns<scores[i]) rank++;
            else {
                eqal++;
            }
        }
        System.out.println(eqal+rank<=p?rank:-1);
    }
}