import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int people = Integer.parseInt(br.readLine());
        int[] time = new int[people];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < people; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int[] sum_time = new int[people];
        int sum = 0;
        for(int i = 0; i < people; i++){
            sum += time[i];
            sum_time[i] = sum;
        }

        int answer = 0;
        for(int i : sum_time){
            answer += i;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    
    }
}
