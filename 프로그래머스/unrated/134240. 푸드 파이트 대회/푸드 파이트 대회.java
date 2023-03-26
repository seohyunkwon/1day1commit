class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i=1; i<food.length; i++){
            if(food[i]/2>0) {
            	for(int j=0; j<food[i]/2; j++) {
            		sb.append(i);
            	}
            }
        }
        answer+=sb.toString()+"0";
        answer+= sb.reverse().toString();
     
        return answer;
    }
}