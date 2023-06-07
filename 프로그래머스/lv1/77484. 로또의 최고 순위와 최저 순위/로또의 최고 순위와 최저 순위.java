import java.util.*;

class Solution {
	 public int[] solution(int[] lottos, int[] win_nums) {
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i:win_nums) {
	        	list.add(i);
	        }
	        int cnt = 0;
	        int zero = 0;
	        for(int i:lottos) {
	        	if(i!=0 && list.contains(i)) {
	        		cnt++; list.remove(new Integer(i));
	        	} else if(i==0) zero++;
	        }
	        int[] answer = {cnt+zero, cnt-zero<cnt?cnt:cnt-zero};
	        for(int i=0; i<answer.length; i++) {
	        	if(answer[i]==6) answer[i]=1;
	        	else if(answer[i]==5) answer[i]=2;
	        	else if(answer[i]==4) answer[i]=3;
	        	else if(answer[i]==3) answer[i]=4;
	        	else if(answer[i]==2) answer[i]=5;
	        	else answer[i]=6;
	        }
	        return answer;
	    }
}