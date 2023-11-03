import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n+1];
        int[] sum = new int[n+1];
        for(int i=1; i<n+1; i++){
            steps[i] = Integer.parseInt(br.readLine());
        }
        if(n==1){
            System.out.println(steps[1]);
            return;
        }
        if(n==2){
            System.out.println(steps[1]+steps[2]);
            return;
        }
        if(n==3){
            System.out.println(Math.max(steps[1]+steps[3], steps[2]+steps[3]));
            return;
        }
        sum[1] = steps[1];
        sum[2] = steps[1]+steps[2];
        sum[3] = Math.max(steps[1], steps[2])+steps[3];

        for(int i=4; i<n+1; i++){
            sum[i] = Math.max(sum[i-3]+steps[i-1], sum[i-2])+steps[i];
        }
        System.out.println(sum[n]);
    }
}
