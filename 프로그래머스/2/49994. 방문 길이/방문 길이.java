import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] arr = new int[11][11];
        int[] start = {0,0};
        int[][] dxdy = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        char[] points = {'U','D','L','R'};
        Map<Character, int[]> map = new HashMap<>();
        for(int i=0; i<points.length; i++){
            map.put(points[i], dxdy[i]);
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            int[] tmp = map.get(dirs.charAt(i));
            int nx = start[0]+tmp[0]; int ny = start[1]+tmp[1];
            if(nx<-5||nx>5||ny<-5||ny>5) continue;
            if(set.add(""+start[0]+start[1]+nx+ny)&&set.add(""+nx+ny+start[0]+start[1])) answer++;
            
            start[0] = nx; start[1] = ny;
        }
        
        return answer;
    }
}