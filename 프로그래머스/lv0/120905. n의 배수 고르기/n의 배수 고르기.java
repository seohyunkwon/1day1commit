import java.util.*;
class Solution {
    public ArrayList solution(int n, int[] numlist) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i:numlist){
            if(i%n==0) answer.add(i);
        }
        return answer;
    }
}