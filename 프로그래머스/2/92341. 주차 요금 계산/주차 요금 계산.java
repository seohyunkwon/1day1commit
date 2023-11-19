import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> input = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for(String s : records){
            StringTokenizer st = new StringTokenizer(s);
            String[] timeArr = st.nextToken().split(":");
            int time = Integer.parseInt(timeArr[0])*60 + Integer.parseInt(timeArr[1]);
            String number = st.nextToken();
            String type = st.nextToken();
            if(type.equals("IN")){
                if(input.containsKey(number)){
                    result.put(number, result.getOrDefault(number,0)+input.get(number));
                }
                input.put(number, (60*24-1) - time);
                continue;
            }
            if(type.equals("OUT")){
                input.put(number, input.get(number)-((60*24-1) - time));
                continue;
            }
        }
        for(String number:input.keySet()){
            result.put(number, result.getOrDefault(number,0)+input.get(number));
        }
        return result.keySet()
            .stream()
            .sorted()
            .mapToInt(num -> calculateFee(result.get(num), fees))
            .toArray();
    }
    
    int calculateFee(int fee, int[] fees){
        System.out.println(fee);
        if(fee<=fees[0]) return fees[1];
        int usage = (int)Math.ceil((fee-fees[0])/(double)fees[2]);
        return usage*fees[3]+fees[1];
    }
}