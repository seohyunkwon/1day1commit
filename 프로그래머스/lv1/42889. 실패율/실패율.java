import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int total = stages.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<total; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
        }
        List<String[]> result = new ArrayList<>();
        for(int i=1; i<=N; i++){
            int tmp = map.getOrDefault(i, 0);
            double rate = total>0?tmp/(double)total:0;
            result.add(new String[]{i+"", rate+""});
            total -= tmp;
        }
     Collections.sort(result, (a, b) -> {
    double failureRateA = Double.parseDouble(a[1]);
    double failureRateB = Double.parseDouble(b[1]);

    if (failureRateA == failureRateB) {
        return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
    }
    return Double.compare(failureRateB, failureRateA);
});
        for(int i=0; i<N; i++){
            answer[i] = Integer.parseInt(result.get(i)[0]);
        }
        
        return answer;
    }
}
