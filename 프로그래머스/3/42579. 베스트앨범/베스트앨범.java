import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, PriorityQueue<Music>> musicMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0)+plays[i]);
            if(!musicMap.containsKey(genres[i])){
                musicMap.put(genres[i], new PriorityQueue<Music>((a,b)->b.play-a.play));
            } 
            musicMap.get(genres[i]).add(new Music(genres[i], plays[i], i));
        }
        
        List<String> rank = new ArrayList<>();
            genresMap.entrySet().stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .forEach(a->rank.add(a.getKey()));
        List<Integer> result = new ArrayList<>();
        for(String genre : rank){
            PriorityQueue<Music> tmp = musicMap.get(genre);
            int n = 2;
            while(n>0){
                if(!tmp.isEmpty()){
                    result.add(tmp.poll().number);
                }   
                n--;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
class Music{
    String genre;
    int play;
    int number;
    Music(String genre, int play, int number){
        this.genre = genre;
        this.play = play;
        this.number = number;
    }
}