import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long start = 0;
        long end = Arrays.stream(arr).max().getAsLong();
        long t = 0;
        long prevT = 0;
        long prevSum = 0;
        while(start<=end){
            t= (start+end)/2;
            long sum = 0;
            for(long i:arr){
                sum+= i>t?i-t:0;
            }
            if(sum<m){
                end = t-1;
            } else if(sum>m) {
                start = t+1;
            } else {
                break;
            }
            if(sum-m<0 && prevSum-m>=0){
                t = prevT;
                sum = prevSum;
            }
            prevT = t;
            prevSum = sum;
        }
        System.out.println(t);
    }
}
