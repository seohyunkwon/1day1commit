import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = tmp[1]-1;
            if(tmp[0]==1){
                for(int j=k; j<n; j+=k+1){
                    switches[j] = switches[j]==1?0:1;
                }
            } else {
                switches[k] = switches[k]==1?0:1;
                int start = k-1;
                int end = k+1;
                while(start>=0 && end<n){
                    if(switches[start]==switches[end]){
                            switches[start] = switches[start]==1?0:1;
                            switches[end] = switches[end]==1?0:1;
                            start--; end++;
                    } else break;

                }
            }

        }

        for(int i=0; i< switches.length; i++){
            System.out.print(switches[i]+((i+1)%20==0?"\n":" "));
        }
    }
}