import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] forward = {"북", "서", "남", "동"};
    static int[] dx = {-1, 0, 1, 0}; // 북 서 남 동                    // 후진 x++ y-- x-- y++
    static int[] dy = {0, 1, 0, -1};  // 북 동 남 서 ( 0 1 2 3 ) ( x-- , y++, x++, y-- )
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
                graph[i][j] = arr[j];
            }
        }
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c, d});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]<0 || tmp[1]<0 || tmp[0]>=n || tmp[1]>=m) continue;;
            if(graph[tmp[0]][tmp[1]]==0) {
                graph[tmp[0]][tmp[1]] = -1;
                cnt++;
            }
            boolean flag = true;
            for(int i=0; i<dx.length; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx <0 || ny < 0 || nx>=n || ny>=m) continue;
                if(graph[nx][ny]==0) {
                    flag = false; break;
                }
            }
            int nx = tmp[0];
            int ny = tmp[1];
            if(flag){
                switch (tmp[2]){
                    case 0 : nx++; break;
                    case 1 : ny--; break;
                    case 2 : nx--; break;
                    case 3 : ny++; break;
                }
                if(nx <0 || ny < 0 || nx>=n || ny>=m) continue;
                if(graph[nx][ny]==1) break;
                else {
                    queue.add(new int[]{nx,ny, tmp[2]});
                }
            } else {
                int head = tmp[2]-1 == -1 ? 3 : tmp[2]-1;
                switch (head){
                    case 0 : nx--; break;
                    case 1 : ny++; break;
                    case 2 : nx++; break;
                    case 3 : ny--; break;
                }
                if(graph[nx][ny]==0) {
                    queue.add(new int[]{nx, ny, head});
                } else {
                    queue.add(new int[]{tmp[0], tmp[1], head});
                }
            }
        }
        System.out.println(cnt);
    }
}
