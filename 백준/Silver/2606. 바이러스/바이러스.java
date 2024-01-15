import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    static boolean[] visited;
    static  ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[n+1];
        queue = new LinkedList<>();
        bfs(1);
        System.out.println(count);

    }

    public static void bfs(int n){
        queue.add(n);
        visited[n] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0; i<graph.get(tmp).size(); i++){
                int j = graph.get(tmp).get(i);
                if(!visited[j]){
                    queue.add(j);
                    visited[j] = true;
                    count++;
                }
            }
        }
    }

}
