import java.io.*;
import java.util.*;

public class Main {
    static List<Person> enemies, original;
    static int N, M, D, removeCount, result = Integer.MIN_VALUE;
    static boolean[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        enemies = new LinkedList<>();
        original = new LinkedList<>();

        select = new boolean[M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                if(st.nextToken().equals("1")) {
                    original.add(new Person(i, j));
                }
            }
        }

        selectArcher(0, 0);

        System.out.println(result);

    }

    static int play() {
        removeCount = 0;
        copy();
        while(enemies.size() != 0) {
            attack();
            moveEnemies();
        }
        return removeCount;
    }

    static void moveEnemies() {
        Set<Integer> removeIdx = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < enemies.size(); i++) {
            enemies.get(i).r++;
            if(enemies.get(i).r >= N) {
                removeIdx.add(i);
            }
        }

        for(int i : removeIdx) {
            enemies.remove(i);
        }
    }


    static void attack() {
        Set<Integer> removeIdx = new TreeSet<>(Collections.reverseOrder());
        Collections.sort(enemies);
        for(int i = 0; i < M; i++) {
            if(!select[i]) continue;
            Person archer = new Person(N, i);
            int min_idx = -1;
            int min_dist = Integer.MAX_VALUE;
            for(int j = 0; j < enemies.size(); j++) {
                Person enemy = enemies.get(j);
                int dist = getDist(archer, enemy);
                if(dist <= min_dist && dist <= D) {
                    min_idx = j;
                    min_dist = dist;
                }
            }
            if(min_idx != -1) removeIdx.add(min_idx);
        }

        removeCount += removeIdx.size();
        for(int i : removeIdx) {
            enemies.remove(i);
        }
    }

    static void selectArcher(int idx, int count) {
        if(count == 3) {
            result = Math.max(play(), result);
            return;
        }
        if(idx >= M) return;
        select[idx] = true;
        selectArcher(idx + 1, count + 1);
        select[idx] = false;
        selectArcher(idx + 1, count);
    }

    static int getDist(Person p1, Person p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }

    static void copy() {
        enemies.clear();
        for(int i = 0; i < original.size(); i++) {
            enemies.add(new Person(original.get(i).r, original.get(i).c));
        }
    }

    static class Person implements Comparable<Person> {
        int r, c;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Person o) {
            return o.c - c;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
