import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        loop:
        for(int i=0; i<arr[0].length(); i++){
            char c = arr[0].charAt(i);
            for(int j=1; j<arr.length; j++){
                if(arr[j].charAt(i)!=c) {
                    sb.append("?");
                    continue loop;
                }
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
