import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for(int i=1; i<=3; i++){
            dp[i] = 1;
        }
        for(int i=4; i<dp.length; i++){
            dp[i] = dp[i-2]+dp[i-3];
        }
        for(int m=0; m<t; m++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
