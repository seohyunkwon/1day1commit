import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
       String str = Arrays.stream(String.valueOf(n).split(""))
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining());
        return Long.parseLong(str);
    }
}