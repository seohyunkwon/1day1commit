import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int max = arr[1]; int min = arr[0];
            sb.append(getLCM(min,max)+"\n");
        }
        System.out.println(sb);
    }

    public static int getGCD(int min, int max){
        if(max==0) return min;
        return getGCD(max, min%max);
    }

    public static int getLCM(int min, int max){
        return min*max/getGCD(min,max);
    }
}
