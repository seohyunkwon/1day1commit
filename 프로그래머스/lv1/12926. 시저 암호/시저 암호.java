import java.util.*;
class Solution {
    public String solution(String s, int n) {
        LinkedList<Character> list = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        for(char c ='A'; c<='Z'; c++){
            list.add(c);
        }
        for(int i=0; i<n; i++){
            list.add(list.poll());
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                sb.append(' ');
                 continue;
            }
           int m= s.charAt(i)-'A';
            if(m>31){
                sb.append((char)(list.get(m-32)+32));
            } else 
            sb.append(list.get(m));
        }
        return sb.toString();
    }
}