class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<food.length; i++){
            int num = food[i]/2;
            sb.append((i+"").repeat(num));
        }
        return sb.toString()+"0"+sb.reverse().toString();
    }
}