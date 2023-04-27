import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<TreeSet<Integer>> graph;
    static int[] result;
    static int k = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new TreeSet<Integer>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[n+1];
        result = new int[n];
        dfs(r);
        Arrays.stream(result).forEach(System.out::println);

    }
    public static void dfs(int n){
        visited[n] = true;
        result[n-1] = k++;
        for(int i:graph.get(n)){
            if(!visited[i]){
                dfs(i);
            }
        }
        return;
    }
}
