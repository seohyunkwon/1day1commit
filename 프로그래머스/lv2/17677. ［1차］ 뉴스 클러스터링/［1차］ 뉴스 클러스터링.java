import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i, i+2).toLowerCase();
            if(tmp.replaceAll("[a-z]","").equals(""))
                list1.add(tmp);
        }
        for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i, i+2).toLowerCase();
            if(tmp.replaceAll("[a-z]","").equals(""))
                list2.add(tmp);
        }
        int n = list1.size();
        int m = 0;
        int k = list2.size();
        for(String s:list1){
            if(list2.contains(s)){
                m++;
                list2.remove(s);
            }
        }
        if(n==m && m==k && m==0) {m=1; n=1; k=1;}
        return (int)((m/(double)(n+k-m))*65536);
    }
}