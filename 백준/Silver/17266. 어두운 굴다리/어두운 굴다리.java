import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [] lights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int end = 0;
        int h = 0;
        loop:
        while(true){
            for(int i=0; i< lights.length; i++){
                int prevE = end;
                start = lights[i]-h;
                end = lights[i]+h;
                if(start>0 && i==0) {
                    h++; continue loop;
                }
                if(start>prevE) {
                    h++; continue loop;
                }
                if(end<n&&i== lights.length-1) {
                    h++; continue loop;
                }
            }
            break;
        }
        System.out.println(h);
    }
}