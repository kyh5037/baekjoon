import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class baekjoon15829 {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static final int R = 31;
    static final int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < alphabet.length(); i++){
            hm.put(alphabet.charAt(i), i + 1);
        }

        int L = Integer.parseInt(br.readLine());

        String str = br.readLine();
        long sum = 0;
        for(int i = 0; i < L; i++){
            sum += (hm.get(str.charAt(i)) * Math.pow(R, i))%M;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
