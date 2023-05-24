import java.util.*;
class Solution {
    public int solution(int a, int b) {
        ArrayList<Integer> list1 = getPrime(a);
        ArrayList<Integer> list2 = getPrime(b);
        for(int i:list1){
            list2.remove(new Integer(i));
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2); list3.add(5);
        list2.removeAll(list3);
        return list2.size()>0?2:1;
    }

    public ArrayList<Integer> getPrime(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int m = n;
        for(int i=2; i<=m; i++){
            while(n%i==0) {
                list.add(i);
                n=n/i;
            }
        }
        return list;
    }
}