import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        LinkedList<Integer> scores = new LinkedList<>();
        for(String s:dartResult.split("[S|D|T|#|*]")){
            if(s.length()!=0) scores.add(Integer.parseInt(s));
        }
        int idx = 0;
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c!='S' && c!='D' && c!='T') continue;
            int times = c=='S'?1:c=='D'?2:3;
            int award = 1;
            if(i<dartResult.length()-1){
                char c2 = dartResult.charAt(i+1);
                switch(c2) {
                    case '*' :
                        award = 2; i++;
                        if(idx!=0){
                            scores.set(idx-1, scores.get(idx-1)*2);
                        }
                        break;
                    case '#' :
                        award = -1; i++;
                        break;
                }
            }
            scores.set(idx, (int)Math.pow(scores.get(idx++),times)*award);
        }
        for(int i:scores){
            answer+=i;
        }
        return answer;
    }
}


