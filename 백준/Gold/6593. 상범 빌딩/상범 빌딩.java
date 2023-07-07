import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {0,0,0,0,1,-1};
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) break;
            String[][][] building = new String[L][R][C];
            Queue<int[]> queue = new LinkedList<>();
            int [] end = new int[3];
            boolean[][][] visited = new boolean[L][R][C];
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String[] tmp = br.readLine().split("");
                    for(int k=0; k<C; k++){
                        building[i][j][k] = tmp[k];
                        if(tmp[k].equals("S")){
                            queue.add(new int[]{i,j,k});
                        }
                        if(tmp[k].equals("E")){
                            end = new int[]{i,j,k};
                        }
                    }
                }
                br.readLine();
            }

            while (!queue.isEmpty()){
                int[] tmp = queue.poll();
                String str = building[tmp[0]][tmp[1]][tmp[2]];
                if(visited[tmp[0]][tmp[1]][tmp[2]]) continue;
                visited[tmp[0]][tmp[1]][tmp[2]]=true;
                for(int i=0; i< dx.length; i++){
                    int nz = tmp[0]+dz[i];
                    int nx = tmp[1]+dx[i];
                    int ny = tmp[2]+dy[i];
                    if(nz<0 || nx<0 || ny<0 || nz>=L || nx>=R || ny>=C) continue;
                    if(visited[nz][nx][ny]) continue;
                    if(building[nz][nx][ny].equals("#")) continue;
                    int cnt = 0;
                    if(!str.equals("S") && !str.equals(".")) cnt = Integer.parseInt(str);
                    building[nz][nx][ny] = cnt+1+"";
                    queue.add(new int[]{nz,nx,ny});
                }
            }

            if(building[end[0]][end[1]][end[2]].equals("E")) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in "+building[end[0]][end[1]][end[2]]+" minute(s).");
            }

        }

    }
}