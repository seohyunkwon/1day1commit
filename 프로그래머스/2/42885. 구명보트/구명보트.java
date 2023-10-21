import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        if(people[0]+people[1]>limit) return people.length;
        int max = people.length;
        for(int i=0; i<people.length; i++){
            for(int j=max-1; j>=i; j--){
                if(i==j) {
                    answer++;
                    break;
                }
                if(people[i]+people[j]<=limit){
                    answer+=max-j;
                    max = j;
                    break;
                }
            }   
        }
        return answer;
    }
}