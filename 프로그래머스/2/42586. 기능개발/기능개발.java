import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Module> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            queue.add(new Module(progresses[i], speeds[i]));
        }
        int day = queue.poll().getTime();;
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Module module = queue.poll();
            cnt++;
            if(module.getTime()>day){
               day = module.getTime();
               list.add(cnt-1);
               cnt = 1; 
            }
        }
        if(cnt!=0) list.add(cnt);
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

class Module{
    int progress;
    int speed;
    int time;
    
    Module(int progress, int speed){
        this.progress=progress;
        this.speed=speed;
        this.time = (int)Math.ceil((100-progress)/(double)speed);
    }
    
    int getTime(){
        return time;
    }
}