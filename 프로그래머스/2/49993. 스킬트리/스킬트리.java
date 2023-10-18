import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees){
            Queue<String> queue = new LinkedList<>();
            for(String tmp:skill.split("")){
                queue.add(tmp);
            }
            String[] arr = s.split("");
            boolean flag = true;
            for(String tmp:arr){
                if(queue.isEmpty()) break;
                if(queue.peek().equals(tmp)){
                    queue.poll();
                } else if(queue.contains(tmp)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}