import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1697 {
    static int subin;
    static int sister;
    static int[] check; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check = new int[100001];

        String[] str = br.readLine().split(" ");
        subin = Integer.parseInt(str[0]);
        sister = Integer.parseInt(str[1]);

        if(subin == sister){ // 이거는 참고하였다. subin, sister가 같은 경우에는 바로 끝낸다.
            System.out.println(0);
        }else{
            bfs();
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        check[subin] = 0;

        while(!queue.isEmpty()){
            int next_num = queue.poll();

            for(int i = 0; i < 3; i++){
                int temp = 0;

                if(i == 0){
                    temp = next_num - 1;
                } else if(i == 1){
                    temp = next_num + 1;
                } else if(i == 2){
                    temp = next_num * 2;
                }

                if(temp == sister && check[temp] != 0){
                    System.out.println(check[temp]);
                    return;
                }

                if(temp >= 0 && temp < check.length && check[temp] == 0){
                    queue.add(temp);
                    check[temp] = check[next_num] + 1;
                }
            }
        }
    }
}
