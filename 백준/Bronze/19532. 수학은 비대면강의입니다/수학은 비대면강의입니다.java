import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tmp = arr[3]*arr[1]-arr[0]*arr[4];
        int y = -1;
        if(tmp==0) y=0;
        else y=(arr[3]*arr[2]-arr[0]*arr[5])/tmp;
        int x = -1;
        if(arr[0]!=0)
             x = (-arr[1]*y+arr[2])/arr[0];
        else if(arr[3]!=0)
            x = (-arr[4]*y+arr[5])/arr[3];
        System.out.println(x+" "+y);

       // f/d-c/a = (e/d-b/a)*y;az
    }
}