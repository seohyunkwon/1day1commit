import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int[] arr2 = new int[n-1];
        for(int i=0; i<arr.length-1; i++){
            arr2[i]=arr[i+1]-arr[i];
        }
        int m = arr2[0];
        for(int i=0; i<arr2.length-1; i++){
            m = getGCD(m,arr2[i+1]);
        }
        int cnt = 0;
        for(int i:arr2){
            cnt+=i/m-1;
        }
        System.out.println(cnt);
    }

    public static int getGCD(int min, int max){
        if(max==0) return min;
        return getGCD(max, min%max);
    }
}