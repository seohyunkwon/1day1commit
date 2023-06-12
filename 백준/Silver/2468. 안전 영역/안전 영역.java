import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        int max = -1;
        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = max>graph[i][j]?max:graph[i][j];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int K=0; K<=max; K++){
            int cnt = 0;
            visited = new boolean[n+1][n+1];
            int[][] test= setSafeZone(graph, K);
            for (int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(test[i][j]==0){
                        cnt++;
                        getSafeZone(i,j,test);
                    }
                }
            }
            list.add(cnt);

        }
        System.out.println(Collections.max(list));
    }

    public static void getSafeZone(int x, int y, int[][] test){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x,y});
        while(!stack.isEmpty()){
            int[] tmp = stack.pop();
            if(test[tmp[0]][tmp[1]]!=0) continue;
            test[tmp[0]][tmp[1]]=-1;
            for(int i=0; i<dx.length; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<1 || ny<1 || nx>n || ny>n || test[nx][ny]!=0) continue;
                stack.add(new int[]{nx, ny});
            }
        }
    }

    public static int[][] setSafeZone(int[][] graph, int K){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        int[][] test = new int[n+1][n+1];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                test[i][j] = graph[i][j]>K?0:-1;
            }
        }

        return test;
    }
}


