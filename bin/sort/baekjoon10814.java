import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class person{
    int age;
    String name;
    person(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class baekjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        ArrayList<person> arr = new ArrayList<>();

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr.add(new person(age, name));
        }

        Collections.sort(arr, new Comparator<person>(){
            @Override
            public int compare(person p1, person p2){
                return Integer.compare(p1.age, p2.age);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(person pe : arr){
            sb.append(pe.age + " " + pe.name + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
