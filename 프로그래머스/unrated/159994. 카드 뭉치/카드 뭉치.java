import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> queue1 = new LinkedList<>();
        for(String s:cards1) {queue1.offer(s);}
        Queue<String> queue2 = new LinkedList<>();
        for(String s:cards2) {queue2.offer(s);}
        int cnt=0;
        for(String s:goal) {
        	if(!queue1.isEmpty() && queue1.peek().equals(s)) {
                cnt++;
                queue1.poll();
        		continue;
        	} else if(!queue2.isEmpty() && queue2.peek().equals(s)) {
                cnt++;
                queue2.poll();
        		continue;
        	}
        	break;
        }
        return cnt==goal.length?"Yes":"No";
    }
}