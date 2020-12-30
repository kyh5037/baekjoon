import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon1874 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;
        for(int i = 1; i <= num; i++){
            stack.push(i);
            sb.append("+\n"); 
            while(!stack.isEmpty()){
                if(stack.peek() == arr[temp]){
                    stack.pop();
                    sb.append("-\n"); 
                    temp++;
                }else{
                    break;
                }
            }
        }
        
        if(!stack.isEmpty()){
            bw.write("NO\n");
        }else{
            System.out.println(sb);
        }
        
        bw.flush();
        bw.close();
    }
}
