import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, int[]> period = new HashMap<>();
        int[] todays =
                Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        for(String s : terms){
            String[] arr = s.split(" ");
            int days = Integer.parseInt(arr[1])*28;
            int day = days%28-1;
            int year = days/(28*12);
            int month = days/28-(year*12);
            period.put(arr[0], new int[]{year, month, day});
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            int[] tmp = period.get(privacy[1]);
            int[] join =
                    Arrays.stream(privacy[0].split("\\."))
                            .mapToInt(Integer::parseInt).toArray();
            int day = (join[2]+tmp[2])%28;
            int month = ((join[2]+tmp[2])/28)+(join[1]+tmp[1])%12;
            int year = join[0]+tmp[0]+((join[2]+tmp[2])/28)+(join[1]+tmp[1])/12;

            if(month == 0) {
                year --; month = 12;
            }
            if(month == 13) {
                year ++; month = 1;
            }
            if(day == 0) {
                day = 28; month--;
            }
            if(day == 29) {
                day = 1; month++;
            }
            if(todays[0]>year) {
                list.add(i+1);
                continue;
            } else if(todays[0]<year){
                continue;
            } else if(todays[1]>month){
                list.add(i+1);
                continue;
            } else if(todays[1]<month){
                continue;
            } else if(todays[2]>day){
                list.add(i+1);
                continue;
            } else {
                continue;
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
