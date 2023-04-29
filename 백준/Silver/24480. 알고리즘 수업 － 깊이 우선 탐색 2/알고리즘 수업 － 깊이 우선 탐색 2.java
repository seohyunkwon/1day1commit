import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int visit = 1;
    static boolean[] visited;
    static int[] result;
    static  ArrayList<PriorityQueue<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            graph.get(a).offer(b);
            graph.get(b).offer(a);
        }
        visited = new boolean[n+1];
        result = new int[n];
        dfs(r);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static void dfs(int n){
        if(visited[n]) return;
        visited[n] = true;
        result[n-1] = visit++;
        while(!graph.get(n).isEmpty()){
            int tmp = graph.get(n).poll();
            dfs(tmp);
        }
    }
}
