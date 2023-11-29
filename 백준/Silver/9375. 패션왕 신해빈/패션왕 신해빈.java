import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int x=0; x<t; x++){
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                String[] tmp = br.readLine().split(" ");
                map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
            }
            int result = map.values()
                    .stream()
                    .reduce(1, (total, num)->total *= (num+1))
                    .intValue();
            System.out.println(result-1);
        }
    }
}
