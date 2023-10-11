import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        LinkedList<String> queue = new LinkedList<>();
        for(char c='a'; c<='z'; c++){
            queue.add(c+"");
        }
        for(String tmp:skip.split("")){
            queue.remove(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int idx = queue.indexOf(s.charAt(i)+"")+index;
            sb.append(queue.get((idx)%queue.size()));
        }
        return sb.toString();
    }
}