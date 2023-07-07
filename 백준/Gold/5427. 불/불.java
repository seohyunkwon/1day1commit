import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        loop:
        for(int k=0; k<n; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int x = 0; int y = 0;
            String[][] graph = new String[h][w];
            for(int i=0; i<h; i++){
                String[] arr = br.readLine().split("");
                for(int j=0; j<w; j++){
                    graph[i][j] = arr[j];
                    if(graph[i][j].equals("@")) {
                        x = i; y = j;
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(graph[i][j].equals("*")){
                        queue.add(new int[]{i,j});
                    }
                }
            }
            boolean[][] visited = new boolean[h][w];
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                if(visited[tmp[0]][tmp[1]]) continue;
                visited[tmp[0]][tmp[1]] = true;
                for(int i=0; i< dx.length; i++){
                    int nx = tmp[0]+dx[i];
                    int ny = tmp[1]+dy[i];
                    if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
                    if(visited[nx][ny]) continue;
                    if(graph[nx][ny].equals("#") || graph[nx][ny].equals("@")||graph[nx][ny].equals("*")) continue;
                    int cnt = (graph[tmp[0]][tmp[1]].equals(".")||graph[tmp[0]][tmp[1]].equals("*")) ? 0 : Integer.parseInt(graph[tmp[0]][tmp[1]]);
                    graph[nx][ny] = cnt+1+"";
                    queue.add(new int[]{nx,ny});
                }
            }

            queue.clear();
            visited = new boolean[h][w];
            queue.add(new int[]{x,y});
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                if(visited[tmp[0]][tmp[1]]) continue;
                visited[tmp[0]][tmp[1]] = true;
                for(int i=0; i< dx.length; i++){
                    int nx = tmp[0]+dx[i];
                    int ny = tmp[1]+dy[i];
                    if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
                    if(visited[nx][ny]) continue;
                    if(graph[nx][ny].equals("#") || graph[nx][ny].equals("*")) continue;
                    int cnt = (graph[tmp[0]][tmp[1]].equals(".")||graph[tmp[0]][tmp[1]].equals("@")) ? 0 : Integer.parseInt(graph[tmp[0]][tmp[1]]);
                    if(!graph[nx][ny].equals(".")) {
                        int m = Integer.parseInt(graph[nx][ny]);
                        if(Math.abs(Math.abs(cnt)-m)<=1) continue;
                    }
                    graph[nx][ny] = cnt-1+"";

                    queue.add(new int[]{nx,ny});
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<w; i++){
                String a = graph[0][i];
                String b = graph[h-1][i];
                if(a.equals("@") || b.equals("@")){
                    System.out.println("1");
                    continue loop;
                }
                if(a.contains("-")){
                    list.add(Integer.parseInt(a)*-1);
                }
                if(b.contains("-")){
                    list.add(Integer.parseInt(b)*-1);
                }
            }
            for(int i=0; i<h; i++){
                String a = graph[i][0];
                String b = graph[i][w-1];
                if(a.equals("@") || b.equals("@")){
                    System.out.println("1");
                    continue loop;
                }
                if(a.contains("-")){
                    list.add(Integer.parseInt(a)*-1);
                }
                if(b.contains("-")){
                    list.add(Integer.parseInt(b)*-1);
                }
            }

            System.out.println(list.size()>0?Collections.min(list)+1:"IMPOSSIBLE");
        }
    }
}