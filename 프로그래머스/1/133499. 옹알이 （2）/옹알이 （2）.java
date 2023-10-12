class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(String s:babbling){
            for(int i=0; i<arr.length; i++){
                s = s.replaceAll(arr[i],i+"");
            }
            if('a'<=s.charAt(0) && s.charAt(0)<='z') continue;
            boolean flag = true;
            for(int i=1; i<s.length(); i++){
                if('a'<=s.charAt(i) && s.charAt(i)<='z') {
                    flag=false;
                    break;
                } else if(s.charAt(i) == s.charAt(i-1)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}