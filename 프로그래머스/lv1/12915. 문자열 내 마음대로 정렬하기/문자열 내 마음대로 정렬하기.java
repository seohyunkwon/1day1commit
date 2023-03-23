import java.util.*;
class Solution {
    public String[] solution(String[] strings, int i) {
        Arrays.sort(strings, new Comparator<String>(){
           public int compare(String s1, String s2){
               if(s1.charAt(i)!=s2.charAt(i)) return s1.charAt(i)-s2.charAt(i);
               else return s1.compareTo(s2);
           }
        });
        return strings;
    
       }
}