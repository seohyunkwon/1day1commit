import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String tmp = phone_book[0];
        for(int i=1; i<phone_book.length; i++){
            if(tmp.length()<=phone_book[i].length() && phone_book[i].substring(0, tmp.length()).equals(tmp)) return false;
            else tmp = phone_book[i];
        }
        return true;
    }
}