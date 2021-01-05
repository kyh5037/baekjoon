import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;

public class baekjoon10928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            String str = br.readLine();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());

            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < byteData.length; i++){
                sb.append(String.format("%02x", 0xFF & byteData[i]));
            }

            bw.write(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        bw.flush();
        bw.close();
    } 
}
