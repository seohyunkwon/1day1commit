import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Player> players = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            players.offer(new Player(level, nickname));
        }

        List<List<Player>> games = new LinkedList<>();
        while(!players.isEmpty()) {
            Player p = players.poll();
            if(games.isEmpty()) {
                List<Player> tmp = new ArrayList<>();
                tmp.add(p);
                games.add(tmp);
            } else {
                boolean isValid = false;
                for(int i = 0; i < games.size(); i++) {
                    List<Player> tmp = games.get(i);
                    if(Math.abs(tmp.get(0).level - p.level) <= 10 && tmp.size() < m) {
                        tmp.add(p);
                        isValid = true;
                        break;
                    }
                }
                if(!isValid) {
                    List<Player> tmp = new ArrayList<>();
                    tmp.add(p);
                    games.add(tmp);
                }
             }
        }
        StringBuilder sb = new StringBuilder();
        for(List<Player> list : games) {
            if(list.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");
            list.sort((p1, p2) -> p1.nickname.compareTo(p2.nickname));
            for(Player p : list) {
                sb.append(p.level+" "+p.nickname+"\n");
            }
        }
        System.out.println(sb);
    }

    static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
}
