import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        return Arrays.stream(arr).mapToInt(Integer::parseInt).min().getAsInt()+" "+Arrays.stream(arr).mapToInt(Integer::parseInt).max().getAsInt();
    }
}