class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number+1];
        for(int i=1; i<=number; i++){
            int count = 0;
            for(int j=1; j<Math.sqrt(i); j++){
                if(i%j==0) count++;
            }
            count = count*2;
            if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i) count++;
            answer+= count<=limit?count:power;
        }
        return answer;
    }
}