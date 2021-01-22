import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class block_map{
    int x;
    int y;
    int distance;
    int block;
    block_map(int x, int y, int distance, int block){
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.block = block;
    }
}

public class baekjoon2206 {
    static int[][] graph;
    static int[][] check;
    static int[] dirx = {-1, 0, 1, 0};
    static int[] diry = {0, 1, 0, -1};
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        graph = new int[N][M];
        check = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] str2 = br.readLine().split("");
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(str2[j]);
                check[i][j] = Integer.MAX_VALUE;
            }
        }

        answer = Integer.MAX_VALUE;

        bfs();

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<block_map> queue = new LinkedList<>();
        queue.add(new block_map(0, 0, 1, 0));
        check[0][0] = 0;

        while(!queue.isEmpty()){
            block_map cur_location = queue.poll();

            if(cur_location.x == N - 1 && cur_location.y == M - 1){
                answer = cur_location.distance;
                break;
            }


            for(int i = 0; i < dirx.length; i++){
                int next_x = cur_location.x + dirx[i];
                int next_y = cur_location.y + diry[i];

                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) continue;

                if(check[next_x][next_y] <= cur_location.block) continue;

                if(graph[next_x][next_y] == 0){
                    check[next_x][next_y] = cur_location.block;
                    queue.add(new block_map(next_x, next_y, cur_location.distance+1, cur_location.block));
                }else{
                    if(cur_location.block == 0){
                        check[next_x][next_y] = cur_location.block + 1;
                        queue.add(new block_map(next_x, next_y, cur_location.distance + 1, cur_location.block));
                    }
                }

            }
        }
    }

    public static boolean check(int x, int y){
        if(x >= 0 && x < N && y >= 0 && y < M){
            return true;
        }else{
            return false;
        }
    }
}
