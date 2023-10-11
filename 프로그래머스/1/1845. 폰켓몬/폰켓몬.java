import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int n = nums.length/2;
        int size = map.keySet().size();
        return n<size?n:size;
    }
}