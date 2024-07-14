import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            if(q.contains(cities[i].toLowerCase())) {
                answer++;
                q.remove(cities[i].toLowerCase());
                q.offer(cities[i].toLowerCase());
                continue;
            }
            
            if(q.size() >= cacheSize) {
                q.poll();
            }
            
            q.offer(cities[i].toLowerCase());
            
            answer+= 5;
        }
        return answer;
    }
}