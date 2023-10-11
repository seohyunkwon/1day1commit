class Solution {
    public int solution(String s) {
        String[] text = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight","nine"};
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i=0; i<10; i++){
            s = s.replaceAll(text[i], number[i]);
        }
        return Integer.parseInt(s);
    }
}