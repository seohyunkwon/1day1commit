import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		for(int j=0; j<a; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int totalteam = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int myteam = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			ArrayList<int[]> list = new ArrayList<int[]>();
			for(int i=0; i<totalteam; i++) {
				list.add(new int[k+1]);
			}
			int[] scores = new int[totalteam];
			int[] cnt = new int[totalteam];
			int[] fin = new int[totalteam];
			for(int i=0; i<m; i++) {
				st  = new StringTokenizer(br.readLine());
				int teamid = Integer.parseInt(st.nextToken())-1;
				int knum = Integer.parseInt(st.nextToken())-1;
				int score = Integer.parseInt(st.nextToken());
				int[] tmp = list.get(teamid);
				tmp[knum] = tmp[knum]>score?tmp[knum]:score;
				cnt[teamid]+=1;
				fin[teamid] = i;
			}
			for(int i=0; i<list.size(); i++) {
				scores[i] = Arrays.stream(list.get(i)).sum();
			}
			
			int rank = 1;
			for(int i=0; i<scores.length; i++) {
				if(i==myteam) continue;
				if(scores[i]>scores[myteam]) rank++;
				if(scores[i]==scores[myteam] && cnt[i]<cnt[myteam]) rank++;
				if(scores[i]==scores[myteam] && cnt[i]==cnt[myteam] && fin[i]<fin[myteam]) rank++;
				
			}
			System.out.println(rank);
		}
	}                                                                      
}
