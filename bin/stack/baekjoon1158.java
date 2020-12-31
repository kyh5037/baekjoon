import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int j = 1; j <= K; j++){
                if(j != K){
                    queue.offer(queue.poll());
                } else {
                    sb.append(queue.poll() + ", "); 
                }
            }
        }

        String temp = sb.substring(0, sb.length() - 2);
        sb = new StringBuilder(temp);
        sb.append(">");

        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }
}
