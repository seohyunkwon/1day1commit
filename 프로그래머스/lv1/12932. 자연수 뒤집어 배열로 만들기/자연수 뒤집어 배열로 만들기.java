class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        String str2 = new StringBuilder(str).reverse().toString();
        int[] answer = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            answer[i] = str2.charAt(i)-'0';
        }
        return answer;
    }
}