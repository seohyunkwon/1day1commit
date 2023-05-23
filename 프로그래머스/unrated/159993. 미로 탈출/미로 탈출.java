
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] graph;
    static Node start, lever, exit;
    static boolean[][] visited;
    static int[][] test;
    static int n,m;
    static int cnt = 1;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        graph = new int[n+1][m+1];
        test = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            String s = " "+maps[i-1];
            for(int j=1; j<=m; j++){
                if(s.charAt(j)=='S') start = new Node(i,j);
                else if(s.charAt(j)=='L') {
                    lever = new Node(i,j); test[i][j]=2;
                }
                else if(s.charAt(j)=='E') {
                    exit = new Node(i,j); test[i][j]=2;
                }

                if(s.charAt(j)=='X') {
                    graph[i][j] = -1;
                    test[i][j]=-1;
                }

            }
        }

        testbfs(start);
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(test[i][j]==0 && cnt!=3) return -1;
            }
        }

        if(bfs(start, lever)){
            if(bfs(lever, exit)){
                return graph[exit.x][exit.y];
            }
        }
        return -1;

    }

    static void testbfs(Node start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        test[start.x][start.y]=1;
        visited[start.x][start.y]=true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x; int y = node.y;
            for(int i=0; i< dx.length; i++){
                int nx = x+dx[i]; int ny = y+dy[i];
                if(nx<1 || ny<1 || nx>n || ny>m) continue;
                if(test[nx][ny]==2) cnt++;
                if(!visited[nx][ny] && test[nx][ny]!=-1) {
                    test[nx][ny] = 1;
                    visited[nx][ny] = true;
                    if(!queue.contains(new Node(nx,ny)))
                        queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean bfs(Node start, Node end){
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x; int y = node.y;
            if(x==end.x && y==end.y) {
                return true;
            }
            for(int i=0; i< dx.length; i++){
                int nx = x+dx[i]; int ny = y+dy[i];
                if(nx<1 || ny<1 || nx>n || ny>m) continue;
                if(graph[nx][ny]!=-1) {
                    graph[nx][ny] = graph[x][y]+1;
                    if(!queue.contains(new Node(nx,ny)))
                        queue.offer(new Node(nx, ny));
                }
            }
        }
        return false;
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x=x; this.y=y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
        @Override
        public boolean equals(Object object){
            Node node = (Node)object;
            if(this.x==node.x && this.y== node.y) return true;
            else return false;
        }
    }
}