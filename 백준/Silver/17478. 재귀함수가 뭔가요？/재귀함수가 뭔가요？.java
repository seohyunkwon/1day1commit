import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String answer;
    static String s;
    static int cnt = 1;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        s="";
        answer = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" +
                "\"재귀함수가 뭔가요?\"\n" +
                "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        recursive(m-1);
        System.out.println(answer+s+"라고 답변하였지.\n");
    }

    public static void recursive(int n){
        if(n<-1) cnt--;
        String tmp = "";
        for(int i=0; i<cnt*4; i++){
            tmp+="_";
        }
        if (n<0) {
            s+= tmp+"라고 답변하였지.\n";
        } else if(n>0){
            s +=  tmp+"\"재귀함수가 뭔가요?\"\n" +
                    tmp+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                    tmp+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                    tmp+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
            cnt++;
        } else {
            s+= tmp+"\"재귀함수가 뭔가요?\"\n" +
                    tmp+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        }

        if(n==-m) return;
        n--; recursive(n);
    }
}
