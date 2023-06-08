import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, name, i);
        }
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age!=o2.age?o1.age-o2.age:o1.idx-o2.idx;
            }
        });
        for(Person p:arr){
            System.out.println(p.age+" "+p.name);
        }
    }
}

class Person{
    int age;
    String name;
    int idx;
    public Person(int age, String name, int idx){
        this.age=age; this.name=name;   this.idx=idx;
    }
}