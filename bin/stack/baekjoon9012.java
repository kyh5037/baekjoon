import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class baekjoon9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            boolean check = true;
            String str = br.readLine();
            char temp;
            for(int j = 0; j < str.length(); j++){
                temp = str.charAt(j);
                if(temp == '('){
                    stack.push(temp);
                }else if(temp == ')'){
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                check = false;
            }

            if(check == true)
                bw.write("YES\n");
            else if(check == false)
                bw.write("NO\n");
            
            stack.clear();
        }
        bw.flush();
        bw.close();
    }
}
