class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        boolean flag = true;
        int j = 0;  
        int k = 0;  
        while(k<str2.length()){
            if(flag) {
                answer += str1.charAt(j);
                j++;
                flag = !flag;
            } else {
                answer +=str2.charAt(k);
                k++;
                flag = !flag;
            }
        }
        return answer;
    }
}