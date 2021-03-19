package baekjoon.bin.codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class location_16953{
    long st;
    int cnt;
    location_16953(long st, int cnt){
        this.st = st;
        this.cnt = cnt;
    }
}

public class baekjoon16953 {
    public static long start, end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        bfs();
    }

    public static void bfs(){
        Queue<location_16953> queue = new LinkedList<>();

        queue.offer(new location_16953(start, 0));

        while(!queue.isEmpty()){
            location_16953 temp = queue.poll();
            
            if(temp.st == end){
                System.out.println(temp.cnt + 1);
                return;
            }

            for(int i = 0; i < 2; i++){
                long x = 0;

                if(i == 0){
                    x = temp.st * 2;
                } else {
                    x = 10*temp.st + 1;
                }

                if(x <= end){
                    queue.offer(new location_16953(x, temp.cnt + 1));
                }
            }
                       
        }
        System.out.println(-1);
    }
}
