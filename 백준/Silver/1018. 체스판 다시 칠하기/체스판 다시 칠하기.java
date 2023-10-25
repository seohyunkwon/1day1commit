import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr1 = {{'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'}};
        char[][] arr2 = {{'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'}};
        char[][] input = new char[n][m];
        for(int i=0; i<n; i++){
            char[] tmp = (char[]) br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                input[i][j] = tmp[j];
            }
        }

        int rangeX = n-8;
        int rangeY = m-8;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<=rangeX; i++){
            for(int j=0; j<=rangeY; j++){
                min = Math.min(min, countArr(input, i, j, arr1));
                min = Math.min(min, countArr(input, i, j, arr2));
            }
        }

        System.out.println(min);

    }

    static int countArr(char[][] input, int rangeX, int rangeY, char[][] arr){
        int cnt = 0;
        for(int i=rangeX; i<rangeX+8; i++){
            for(int j=rangeY; j<rangeY+8; j++){
                if(input[i][j]!=arr[i-rangeX][j-rangeY]) cnt++;
            }
        }
        return cnt;
    }
}
