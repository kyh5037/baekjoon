import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class block_map{
    int x;
    int y;
    int block;
    block_map(int x, int y, int block){
        this.x = x;
        this.y = y;
        this.block = block;
    }
}

public class baekjoon2206_modify {
    static int[][] graph;
    static int[][] block_count;
    static int[][] min;
    static int[] dirx = {-1, 0, 1, 0};
    static int[] diry = {0, 1, 0, -1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        graph = new int[N][M];
        block_count = new int[N][M];
        min = new int[N][M];
        
        for(int i = 0; i < N; i++){
            String[] num = br.readLine().split("");
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(num[j]);
            }
        }

        for(int[] row : block_count)
             Arrays.fill(row, 2);

        int answer = bfs();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    public static int bfs(){
        Queue<block_map> queue = new LinkedList<>();
        queue.offer(new block_map(0, 0, 0));
        min[0][0] = 1;
        block_count[0][0] = 0;

        while(!queue.isEmpty()){
            block_map cur_location = queue.poll();

            if(cur_location.x == N - 1 && cur_location.y == M - 1){
                return min[cur_location.x][cur_location.y];
            }

            for(int i = 0; i < dirx.length; i++){
                int next_x = cur_location.x + dirx[i];
                int next_y = cur_location.y + diry[i];

                if(check(next_x, next_y) && graph[next_x][next_y] == 1){
                    if(cur_location.block == 0){
                        queue.add(new block_map(next_x, next_y, 1));
                        min[next_x][next_y] = min[cur_location.x][cur_location.y] + 1;
                        block_count[next_x][next_y] = 1;
                    }
                } else if(check(next_x, next_y) && graph[next_x][next_y] == 0){
                    if(block_count[next_x][next_y] > cur_location.block){
                        queue.add(new block_map(next_x, next_y, cur_location.block));
                        min[next_x][next_y] = min[cur_location.x][cur_location.y] + 1;
                        block_count[next_x][next_y] = cur_location.block;
                    }
                }
            }
        }
              
        return -1;
    }

    public static boolean check(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M){
            return false;
        }else{
            return true;
        }
    }
}
