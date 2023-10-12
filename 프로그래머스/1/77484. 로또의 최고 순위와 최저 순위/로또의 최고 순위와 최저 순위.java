import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i:win_nums){
            list.add(i);
        }
        for(int i:lottos){
            list.remove(new Integer(i));
        }
        int zero = (int)Arrays.stream(lottos).filter(a->a==0).count();
        int n = win_nums.length-list.size();
        int max = n+zero==6?1:(n+zero==5?2:(n+zero==4)?3:(n+zero==3)?4:(n+zero==2?5:6));
        int min = n==6?1:(n==5?2:(n==4)?3:(n==3)?4:(n==2?5:6));
        return new int[]{max, min};
    }
}