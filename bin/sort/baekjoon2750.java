import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class baekjoon2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(br.readLine());    
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i] + "\n");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
