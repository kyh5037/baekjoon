import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class baekjoon2002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            hm.put(br.readLine(), i);
        }

        int[] car = new int[N];
        for(int i = 0; i < N; i++){
            car[i] = hm.get(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(car[i] > car[j]){
                    count++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
