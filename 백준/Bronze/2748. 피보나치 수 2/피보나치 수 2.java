import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<2) System.out.println(n);
        else System.out.println(fibo(n));
    }
    public static long fibo(int n){
        long num1 = 0;
        long num2 = 1;

        long[] arr = new long[n];

        for(int i=1; i<n; i++) {
            arr[i] = num1 + num2;
            num1 = num2;
            num2 = arr[i];
        }
        return arr[n-1];
    }

}
