import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int[][] map = new int[9][9];
	static List<int[]> list = new ArrayList<>();
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new int[]{i, j});
			}
		}
		
		visit = new boolean[list.size()];
		backtracking(0);
		
	}
	
	static void backtracking(int idx) {
		if(idx == list.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(map[i][j] == 0) return;
				}
			}
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j] +" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int[] tmp = list.get(idx);
		for(int i = 1; i < 10; i++) {
			if(!check(tmp, i)) continue;
			map[tmp[0]][tmp[1]] = i;
			backtracking(idx + 1);
			map[tmp[0]][tmp[1]] = 0;
		}
	}
	
	static boolean check(int[] point, int num) {
		boolean[] rows = new boolean[10];
		boolean[] cols = new boolean[10];
		boolean[] square = new boolean[10];
		for(int i = 0; i <9; i++) {
			cols[map[i][point[1]]] = true;
			rows[map[point[0]][i]] = true;
		}
		int x = (point[0] / 3) * 3;
		int y = (point[1] / 3) * 3;
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				if(i == point[0] && j == point[1]) continue;
				square[map[i][j]] = true;
			}
		}
		
		return !rows[num] && !cols[num] && !square[num]; 
	}
}
