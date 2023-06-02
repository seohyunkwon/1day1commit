import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=3; i++){
            map.put(i,0);
        }
        for(int i=0; i<answers.length; i++){
            map.put(1, map.get(1)+((answers[i]==arr1[i%5])?1:0));
            map.put(2, map.get(2)+((answers[i]==arr2[i%8])?1:0));
            map.put(3, map.get(3)+((answers[i]==arr3[i%10])?1:0));
        }
        int max = Collections.max(map.values());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=3;i++){
            if(map.get(i)==max) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}