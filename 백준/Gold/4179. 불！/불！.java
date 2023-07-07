import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int r, c,x,y;
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        x = 0; y = 0;
        for (int i = 0; i < r; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = tmp[j];
                if(arr[i][j].equals("J")) {
                    x = i; y = j;
                }
            }
        }
        Queue<int[]> fireQueue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String str = arr[i][j];
                if(str.equals("F")) fireQueue.add(new int[]{i,j});
            }
        }
        fire(fireQueue);
        exit(x,y);
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0; i<c; i++){
            String a = arr[0][i];
            String b = arr[r-1][i];
            if(a.equals("J")||b.equals("J")) {
                System.out.println("1");
                return;
            }
            if(!a.equals("#") && !a.equals("F") && !a.equals(".")){
                int tmp = Integer.parseInt(a);
                if(tmp<0){
                    tmp = tmp*-1;
                    result = tmp>result?result:tmp;
                    flag = true;
                }
            }
            if(!b.equals("#") && !b.equals("F") && !b.equals(".")){
                int tmp = Integer.parseInt(b);
                if(tmp<0){
                    tmp = tmp*-1;
                    result = tmp>result?result:tmp;
                    flag = true;

                }
            }
        }

        for(int i=0; i<r; i++){
            String a = arr[i][0];
            String b = arr[i][c-1];
            if(a.equals("J")||b.equals("J")) {
                System.out.println("1");
                return;
            }
            if(!a.equals("#") && !a.equals("F") && !a.equals(".")){
                int tmp = Integer.parseInt(a);
                if(tmp<0){
                    tmp = tmp*-1;
                    result = tmp>result?result:tmp;
                    flag = true;
                }
            }
            if(!b.equals("#") && !b.equals("F") && !b.equals(".")){
                int tmp = Integer.parseInt(b);
                if(tmp<0){
                    tmp = tmp*-1;
                    result = tmp>result?result:tmp;
                    flag = true;

                }
            }
        }
        System.out.println(flag?result+1:"IMPOSSIBLE");



    }

    public static void fire(Queue<int[]> queue) {
        boolean[][] visited = new boolean[r][c];
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            visited[tmp[0]][tmp[1]] = true;
            String s = arr[tmp[0]][tmp[1]];
            for(int k=0; k<dx.length; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];
                if(nx<0 || ny<0 || nx>= r || ny>=c   ||
                    visited[nx][ny]) continue;
                if(arr[nx][ny].equals(".")){
                    if(s.equals("F")) {
                        arr[nx][ny] = "0";
                    } else {
                        arr[nx][ny] = Integer.parseInt(s)+1+"";
                    }
                    queue.add(new int[]{nx,ny});
                }

            }
        }
    }

    public static void exit(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[][] visited = new boolean[r][c];
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            visited[tmp[0]][tmp[1]] = true;
            String s = arr[tmp[0]][tmp[1]];
            for(int k=0; k<dx.length; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];
                if(nx<0 || ny<0 || nx>= r || ny>=c   ||
                        visited[nx][ny]) continue;
                if(arr[nx][ny].equals("#") || arr[nx][ny].equals("F")) continue;
                int t = (s.equals("J")||s.equals("."))?0:Integer.parseInt(s);
                    if(!arr[nx][ny].equals("J") && !arr[nx][ny].equals(".")){
                        int m = Integer.parseInt(arr[nx][ny]);
                        if(Math.abs(t)>=m) continue;
                    }

                    arr[nx][ny] = (t-1)+"";
                    queue.add(new int[]{nx,ny});


            }
        }
    }
}