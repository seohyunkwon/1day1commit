import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int visit = 1;
    static boolean[] visited;
    static int[] result;
    static  ArrayList<TreeSet<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new TreeSet<>());
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        result[r-1] = visit++;
        visited[r]=true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            while(!graph.get(tmp).isEmpty()){
                int k = graph.get(tmp).pollFirst();
                if(!visited[k]){
                    queue.add(k);
                    visited[k] = true;
                    result[k-1] = visit++;
                }
            }
        }

        Arrays.stream(result).forEach(System.out::println);

    }
}
