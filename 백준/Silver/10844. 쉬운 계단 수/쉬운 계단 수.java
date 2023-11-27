import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][10];
        for(int i=1; i<10; i++){
            dp[0][i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j+1]%1000000000;
                    continue;
                }
                if(j==9){
                    dp[i][j] = dp[i-1][j-1]%1000000000;
                    continue;
                }
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1]%1000000000;
            }
        }
        System.out.println(Arrays.stream(dp[n-1]).sum()%1000000000);
    }
}
