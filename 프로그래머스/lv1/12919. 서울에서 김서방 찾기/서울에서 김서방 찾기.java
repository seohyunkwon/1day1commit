class Solution {
    public String solution(String[] seoul) {
        int j=0;
        for(String i:seoul){
            if(i.equals("Kim")) break;
            else j++;
        }
        return "김서방은 "+j+"에 있다";
    }
}