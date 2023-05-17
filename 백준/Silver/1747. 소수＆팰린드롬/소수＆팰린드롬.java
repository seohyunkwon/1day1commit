import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10000000];
        arr[1] = true;
        for(int i=2; i<arr.length; i++){
            if(arr[i]) continue;
            for(int j=2*i; j<arr.length; j+=i){
                arr[j] = true;
            }
        }

        for(int i=n; i< arr.length; i++){
            if(arr[i]) continue;
            if(isPalind(i)) {
                System.out.println(i);
                return;
            }
        }

    }

    public static boolean isPalind(int n){
        String s = String.valueOf(n);
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end --;
        }
        return true;
    }
}