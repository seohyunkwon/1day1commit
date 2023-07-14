import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String myString) {
        return Arrays.stream(myString.split("")).map(a->a.toUpperCase()).collect(Collectors.joining());
    }
}