import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i< arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        loop:
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(sum-(arr[i]+arr[j])==100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break loop;
                }
            }
        }
        Arrays.sort(arr);
        for(int i=2; i<arr.length; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);

    }
}
