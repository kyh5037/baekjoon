import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] num = str.split("-");
        
        int sum = 0;
        for(int i = 0; i < num.length; i++){
            String[] add = num[i].split("\\+");
            int temp = 0;
            for(int j = 0; j < add.length; j++){
                temp += Integer.parseInt(add[j]);
            }

            if(i == 0){
                sum += temp;
            }else{
                sum -= temp;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
