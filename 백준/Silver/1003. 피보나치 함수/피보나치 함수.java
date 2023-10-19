import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] arr = new long[41];
        long[][] cnt = new long[41][2];
        for(int i=0; i<arr.length; i++){
            if(i<2) arr[i] = i;
            else arr[i] = arr[i-1]+arr[i-2];
            if(i==0) cnt[i][0] = 1;
            else if(i==1) cnt[i][1] = 1;
            else {
                cnt[i][0] = cnt[i-1][0]+cnt[i-2][0];
                cnt[i][1] = cnt[i-1][1]+cnt[i-2][1];
            }
        }

        for(int n=0; n<t; n++){
            int i = Integer.parseInt(br.readLine());
            System.out.println(cnt[i][0]+" "+cnt[i][1]);
        }





    }
}
