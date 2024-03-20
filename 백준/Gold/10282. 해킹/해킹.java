import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc<= t; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken())-1;
        	List<Computer>[] graph = new ArrayList[n];
        	boolean[] visit = new boolean[n];
        	int[] time = new int[n];
        	Arrays.fill(time, Integer.MAX_VALUE);
        	time[c] = 0;
        	
        	for(int i = 0; i < n; i++) {
        		graph[i] = new ArrayList<>();
        	}
        	
        	for(int i = 0; i < d; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken())-1;
        		int b = Integer.parseInt(st.nextToken())-1;
        		int s = Integer.parseInt(st.nextToken());
        		graph[b].add(new Computer(a, s));
        	}
        	
        	PriorityQueue<Computer> pq = new PriorityQueue<>((c1, c2) -> time[c1.idx] - time[c2.idx]);
        	pq.offer(new Computer(c, 0));
        	
        	while(!pq.isEmpty()) {
        		Computer computer = pq.poll();
        		if(visit[computer.idx]) continue;
        		visit[computer.idx] = true;
        		
        		for(int i = 0; i < graph[computer.idx].size(); i++) {
        			Computer tmp = graph[computer.idx].get(i);
        			if(time[tmp.idx] > time[computer.idx] + tmp.time) {
        				time[tmp.idx] = time[computer.idx] + tmp.time;
        				pq.offer(tmp);
        			}
        		}
        	}
        	
        	int count = 0;
        	int max_time = 0;
        	
        	for(int i = 0; i < time.length; i++) {
        		if(time[i] == Integer.MAX_VALUE) continue;
        		count++;
        		max_time = Math.max(max_time, time[i]);
        	}
        	System.out.println(count + " " + max_time);
        }
    }
}

class Computer {
	int idx, time;

	public Computer(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}