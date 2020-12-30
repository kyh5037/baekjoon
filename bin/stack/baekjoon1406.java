import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();

        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++){
            lstack.push(str.charAt(i));    
        }

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String[] edit = br.readLine().split(" ");

            switch(edit[0]){
            case "L":
                if(!lstack.isEmpty()){
                    rstack.push(lstack.pop());
                }
                break;
            case "D":
                if(!rstack.isEmpty()){
                    lstack.push(rstack.pop());
                }
                break;
            case "B":
                if(!lstack.isEmpty()){
                    lstack.pop();
                }
                break;
            case "P":
                lstack.push(edit[1].charAt(0));
                break;
            }
        }

        while(!lstack.isEmpty()){
            rstack.push(lstack.pop());
        }

        while(!rstack.isEmpty()){
            System.out.print(rstack.pop());
        }


    }
}
