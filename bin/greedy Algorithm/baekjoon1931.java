import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class time{
    int start_time;
    int end_time;
    time(int start_time, int end_time){
        this.start_time = start_time;
        this.end_time = end_time;
    }
}

public class baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<time> list = new ArrayList<>();
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i ++){
            st = new StringTokenizer(br.readLine());
            list.add(new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<time>(){
            @Override
            public int compare(time t1, time t2){
                if(t1.end_time == t2.end_time){
                    return Integer.compare(t1.start_time, t2.start_time);
                }
                return Integer.compare(t1.end_time, t2.end_time);
            }
        });
        
        int count = 0;
        int end_time = 0;
        for(time t : list){
            if(t.start_time >= end_time){
                end_time = t.end_time;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
