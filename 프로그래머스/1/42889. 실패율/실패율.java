import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=N+1; i++){
            map.put(i, 0);
        }
        for(int i=0; i<stages.length; i++){
            map.put(stages[i], map.get(stages[i])+1);
        }
        int total = stages.length;
        List<Stage> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            double rate = map.get(i)==0?0:map.get(i)/(double)total;
            total -= map.get(i);
            list.add(new Stage(i, rate));
        }
        Collections.sort(list, 
                         (a,b)->a.getRate()==b.getRate()?a.getLev()-b.getLev():
                         b.getRate()>a.getRate()?1:-1
                        );
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).getLev();
        }
        return answer;
    }
}

class Stage{
    int lev;
    double rate;
    public Stage(int lev, double rate){
        this.lev = lev; this.rate=rate;
    }
    public int getLev() {return lev;}
    public double getRate() {return rate;}
    public String toString() {return ""+lev;}
}