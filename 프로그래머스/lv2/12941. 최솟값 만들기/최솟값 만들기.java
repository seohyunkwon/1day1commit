import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0; int n = A.length-1;
    
        for(int i=0; i<A.length; i++){
            
            answer += A[i] * B[n--];
        }

        return answer;
    }
}