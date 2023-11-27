import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];
        result[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            int cnt = 0;
            for(int j= i+1; j<n; j++){
                if(arr[i]>=arr[j]) continue;
                cnt = Math.max(result[j], cnt);
            }
            result[i] = cnt+1;
        }
        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}
