import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int total = Integer.parseInt(br.readLine());
        int max = total/arr.length;
        for(int i=0; i<arr.length; i++){
            total -= arr[i];
            if(total<0) break;
            if(i==arr.length-1){
                max = arr[arr.length-1];
            } else{
                int tmp = total/(arr.length-1-i);
                max = max>tmp?max:tmp;
            }
        }
        System.out.println(max);
    }
}
