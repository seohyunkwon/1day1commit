import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] last = new int[201];
            int[] result = new int[201];
            int cnt = 1;
            for(int j=0; j<scores.length; j++){
                map.put(scores[j], map.getOrDefault(scores[j],0)+1);
                if(map.getOrDefault(scores[j],0)==5) last[scores[j]] = j+1;
            }
            int[] count = new int[201];
            for(int j=0; j<scores.length; j++){
                if(map.get(scores[j])<6) continue;
                if(count[scores[j]]<4) {
                    result[scores[j]]+=cnt++;
                    count[scores[j]]+=1;
                } else {
                    cnt++;
                }
            }

            int team = 0;
            int min = Integer.MAX_VALUE;
            for(int j:map.keySet()){
                if(map.get(j)<6) continue;
                if(min == result[j]){
                    if(last[j]<last[team]){
                      team = j;
                      min = result[j];
                    }
                } else if(min>result[j]){
                    team = j;
                    min = result[j];
                }
            }
            System.out.println(team);
        }
    }
}