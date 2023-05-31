import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        for(String s:cities){
            s = s.toLowerCase();
            if(queue.contains(s)){
                queue.remove(s);
                queue.offer(s);
                answer+=1;
            } else {
                if(queue.size()>=cacheSize){
                    queue.poll();
                }
                if(cacheSize!=0) queue.add(s);
                answer+=5;
            }
        }
        return answer;
    }
}