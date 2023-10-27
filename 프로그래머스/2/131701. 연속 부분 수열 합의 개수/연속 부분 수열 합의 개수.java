import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] test = new int[elements.length*2];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< test.length; i++){
            test[i] = elements[i% elements.length];
        }
        for(int i=1; i<test.length; i++){
            test[i] += test[i-1];
        }
        for(int i=1; i<=elements.length; i++){
            for(int j=test.length-1; j>i-1; j--){
                set.add(test[j]-test[j-i]);
            }
        }
        return set.size();
    }
}