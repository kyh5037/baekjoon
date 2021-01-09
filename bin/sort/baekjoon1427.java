import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Integer[] arr = new Integer[str.length()];

        for(int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
