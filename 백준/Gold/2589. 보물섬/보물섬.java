import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] graph = new int[l][w];
        for(int i=0; i< graph.length; i++){
            String s = br.readLine();
            for(int j=0; j< graph[i].length; j++){
                if(s.charAt(j)=='W') graph[i][j] = -1;
                else graph[i][j] = 0;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< graph.length; i++){
            for(int j=0; j< graph[i].length; j++){
                if(graph[i][j]==0) list.add(bfs(i,j,graph));
            }
        }
        System.out.println(Collections.max(list)-1);

    }

    public static int bfs(int x, int y, int[][] graph){
        int[][] test = new int[graph.length][graph[0].length];
        for(int i=0; i< test.length; i++){
            for(int j=0; j< test[i].length; j++){
                test[i][j] = graph[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        test[x][y] = 1;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx<0 || ny<0 || nx>=test.length || ny>=test[0].length || test[nx][ny]!=0) continue;
                queue.add(new int[]{nx, ny});
                test[nx][ny]= test[tmp[0]][tmp[1]]+1;
            }
        }
        int max = 0;
        for(int i=0; i< test.length; i++){
            for(int j=0; j< test[i].length; j++){
                max = Math.max(test[i][j],max);
            }
        }
        return max;
    }
}
