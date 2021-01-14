import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        long price = 0;
        long[] line = new long[count - 1];
        long[] city = new long[count];
    
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < line.length; i++){
            line[i] = Integer.parseInt(st.nextToken());
        } 

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < city.length; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        price = line[0] * city[0];
        int now = 0;
        int next = now + 1;
        while(next < count - 1){
            if(city[now] < city[next]){
                price += city[now] * line[next];
            }else{
                price += city[next] * line[next];
                now = next; 
            }
            next++;
        }

        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
    }
}
