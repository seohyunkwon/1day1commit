import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
                return Arrays.stream(myString.split("x")).filter(s->s.equals("")==false).sorted().toArray(String[]::new);

    }
}