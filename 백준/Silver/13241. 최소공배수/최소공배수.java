import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int max = arr[1]; int min = arr[0];
        sb.append(getLCM(min,max)+"\n");
        
        System.out.println(sb);
    }

    public static long getGCD(long min, long max){
        if(max==0) return min;
        return getGCD(max, min%max);
    }

    public static long getLCM(long min, long max){
        return min*max/getGCD(min,max);
    }
}
