
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<answer.length; i++) {
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
        		list.add(array[j]);
        	}
        	Collections.sort(list);
        	answer[i]=list.get(commands[i][2]-1);
        }
        return answer;
    }
}