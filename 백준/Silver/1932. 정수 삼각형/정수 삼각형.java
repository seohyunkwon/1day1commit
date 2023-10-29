import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(new int[i]);
        }
        for(int i=0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] tmp = list.get(i);
            if(i==0){
                tmp[0] = arr[0];
            }
            else {
                for (int j = 0; j < arr.length; j++) {
                    tmp[j] = arr[j];
                }
            }
            if(i==0) continue;
            for(int j=0; j<arr.length; j++){
                if(j==0) tmp[j] += list.get(i-1)[j];
                else if(j==arr.length-1) tmp[j] += list.get(i-1)[j-1];
                else tmp[j] += Math.max(list.get(i-1)[j-1], list.get(i-1)[j]);
            }
        }
        int result = Arrays.stream(list.get(n-1)).max().getAsInt();
        System.out.println(result);
    }
}
