import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []a) {
        ArrayList<Integer>list=new ArrayList<Integer>();
        int prev = a[0];
        list.add(prev);
        for(int i=1; i<a.length; i++){
            if(a[i]==prev) continue;
            else list.add(a[i]);
            prev=a[i];
        }

        return list;
    }
}