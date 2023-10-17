import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length*5;
        int answer = 0;
        PriorityQueue<Page> queue = new PriorityQueue<>((a,b)->a.recentlyUse-b.recentlyUse);
        Set<String> set = new HashSet<>(); 
        for(int i=0; i<cities.length; i++){
            String s = cities[i].toLowerCase();
            if(set.contains(s)) {
                answer+=1;
                queue.removeIf(a->a.city.equals(s));
                queue.add(new Page(s,i));
            } else {
                if(queue.size()>=cacheSize) {
                    Page page = queue.poll();
                    set.remove(page.city);
                }
                queue.add(new Page(s, i));
                set.add(s);
                answer+=5;
            }
        }
        return answer;
    }
}

class Page{
    String city;
    int recentlyUse;

    public int getRecentlyUse() {
        return recentlyUse;
    }

    public void setRecentlyUse(int recentlyUse) {
        this.recentlyUse = recentlyUse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Page(String city, int recentlyUse) {
        this.city = city;
        this.recentlyUse = recentlyUse;
    }
}