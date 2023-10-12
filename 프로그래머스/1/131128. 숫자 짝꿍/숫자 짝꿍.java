import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();
        PriorityQueue<Integer> answer = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<X.length(); i++){
            mapX.put(X.charAt(i)-'0', mapX.getOrDefault(X.charAt(i)-'0', 0)+1);
        }
        for(int i=0; i<Y.length(); i++){
            mapY.put(Y.charAt(i)-'0', mapY.getOrDefault(Y.charAt(i)-'0', 0)+1);
        }
        for(int i=0; i<10; i++){
            int min = Math.min(mapX.getOrDefault(i,0), mapY.getOrDefault(i,0));
            while(min>0) {
                answer.add(i);
                min--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()){
            sb.append(answer.poll());
        }
        if(sb.length()==0) sb.append(-1);
        return sb.toString().replaceAll("0","").length()==0?"0":sb.toString();
    }
}