import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.ArrayList;

class point_list{
    int x;
    int y;
    point_list(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<point_list> list = new ArrayList<>();
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new point_list(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        Collections.sort(list, new Comparator<point_list>(){
            @Override
            public int compare(point_list p1, point_list p2){
                if(p1.x == p2.x) return Integer.compare(p1.y, p2.y);
                return Integer.compare(p1.x, p2.x);
           } 
        });

        StringBuilder sb = new StringBuilder();
        for(point_list data : list){
            sb.append(data.x + " " + data.y + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
