import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = Arrays.stream(new int[n]).map(a->1).toArray();
        ArrayList<int[]> list = new ArrayList<>();
        for(int j=0; j<n; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[]{w,h});
        }

        for(int i=0; i<n; i++){
            int[] a = list.get(i);
            for(int j=0; j<n; j++){
                if(i==j) continue;
                int[] b = list.get(j);
                if(a[0]<b[0] &&a[1]<b[1]) result[i] = result[i]+1;
            }
        }
        Arrays.stream(result).forEach(num->System.out.printf("%d ",num));
    }
}