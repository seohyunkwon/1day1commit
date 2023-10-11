import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return (String) s.chars().mapToObj(i->String.valueOf((char)i)).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}