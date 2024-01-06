import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] boys = new int[6];
        int[] girls = new int[6];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 학생 수
        int K = sc.nextInt();   // 최대 인원 수
        for(int i=0; i<N; i++){
            int S = sc.nextInt();   // 성별
            int Y = sc.nextInt();   // 학년
            if(S == 1) {
                boys[Y-1] += 1;
                continue;
            }
            girls[Y-1] += 1;
        }
        int total = 0;
        for(int i=0; i< boys.length; i++) {
            total += Math.ceil(boys[i]/(double)K);
            total += Math.ceil(girls[i]/(double)K);
        }
        System.out.println(total);
    }
}
