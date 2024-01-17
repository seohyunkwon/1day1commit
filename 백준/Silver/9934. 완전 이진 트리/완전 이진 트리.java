import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static int[] buildings;
    static Map<Integer, StringBuilder> result;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        buildings = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        result = new LinkedHashMap<>();
        for(int i=0; i<K; i++) {
            result.put(i, new StringBuilder());
        }
        findRoot(0, buildings.length, 0);
        for(int i=0; i<K; i++) {
            System.out.println(result.get(i));
        }

    }

    private static void findRoot(int start, int end, int depth){
        if(depth == K) return;
        int mid = (start+end)/2;
        result.get(depth).append(buildings[mid]+" ");
        findRoot(start, mid, depth+1);
        findRoot(mid+1, end, depth+1);
    }
}