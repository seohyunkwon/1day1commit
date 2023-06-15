import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[m][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int j=m-d; j<m-b; j++){
                for(int l=a; l<c; l++){
                    graph[j][l] = -1;
                }
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==0){
                    int re = bfs(i,j,graph);
                    list.add(re);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list){
            System.out.print(i+" ");
        }
    }

    public static int bfs(int x, int y, int[][] graph){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        graph[x][y] = 1;
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            x=tmp[0]; y = tmp[1];
            for(int i=0; i<dx.length; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if( nx<0 || ny<0 || nx>= graph.length || ny>=graph[0].length || graph[nx][ny]==-1) continue;
                if(graph[nx][ny]==0){
                    graph[nx][ny] = ++cnt;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return graph[x][y];
    }
}
