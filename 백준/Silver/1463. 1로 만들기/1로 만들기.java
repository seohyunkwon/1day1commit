import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            if(i<4){
                if(i==1) arr[i] =0;
                else arr[i] = 1;
                continue;
            }
            long three = 0;
            long two = 0;

            if(i%3==0){
                three = arr[i/3]+1;
            }

            if(i%2==0){
                two = arr[i/2]+1;
            }

            if(three==0) three = Long.MAX_VALUE;
            if(two==0) two = Long.MAX_VALUE;

            arr[i] = Math.min(three, two);

            long tmp = arr[i-1]+1;
            arr[i] = Math.min(arr[i], tmp);

        }
        System.out.println(arr[n]);
    }
}
