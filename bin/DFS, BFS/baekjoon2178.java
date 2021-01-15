import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class location_2178{
    int x;
    int y;
    location_2178(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon2178 {
    static int N, M;
    static int[][] graph;
    static int[][] min_graph;
    static int count;
    static int[] dirx = {-1, 0, 1, 0};
    static int[] diry = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        graph = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] num = br.readLine().split("");
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(num[j]);
            }
        }

        min_graph = new int[N][M];
        min_graph[0][0] = 1;
        bfs();

        bw.write(String.valueOf(min_graph[N-1][M-1]));
        bw.flush();
        bw.close();
        
    }

    public static void bfs(){
        Queue<location_2178> queue = new LinkedList<>();
        queue.offer(new location_2178(0, 0));
        graph[0][0] = 0;

        while(!queue.isEmpty()){
            location_2178 temp = queue.poll();

            for(int i = 0; i < dirx.length; i++){
                int next_x = temp.x + dirx[i];
                int next_y = temp.y + diry[i];

                if(check(next_x, next_y)){
                    queue.add(new location_2178(next_x, next_y));
                    min_graph[next_x][next_y] = min_graph[temp.x][temp.y] + 1;

                }
            }
        }
    }

    public static boolean check(int x, int y){
        if(x <= -1 || x >= N || y <= -1 || y >= M){
            return false;
        }

        if(graph[x][y] == 0){
            return false;
        }else{
            graph[x][y] = 0;
            return true;
        }
    }
}
