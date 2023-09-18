import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for(int i=3; i<arr.length; i++){
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n-1]);
        }
    }
}
