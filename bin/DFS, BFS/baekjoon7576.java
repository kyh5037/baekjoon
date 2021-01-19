import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class tomato{
    int x;
    int y;
    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon7576 {
    static int[][] graph;
    static Queue<tomato> queue;
    static int[] dirx = {-1, 0, 1, 0};
    static int[] diry = {0, 1, 0, -1};
    static int M, N;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();

        String[] arr = br.readLine().split(" ");
        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);
        graph = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int temp = Integer.parseInt(str[j]);
                if(temp == 1){
                    queue.offer(new tomato(i, j));
                }
                graph[i][j] = temp;
            }
        }
        
        bfs();
        
        int max = 0;
        boolean no_tomato = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(max < graph[i][j]){
                    max = graph[i][j];
                }else if(graph[i][j] == 0){
                    no_tomato = true;
                }
            }
        }

        if(no_tomato == true){
            System.out.println(-1);
        }else{
            System.out.println(max - 1);
        }

    }

    public static void bfs(){
        
        while(!queue.isEmpty()){
            tomato ripe_tomato = queue.poll();
            
            for(int i = 0; i < dirx.length; i++){
                int next_tomato_x = ripe_tomato.x + dirx[i];
                int next_tomato_y = ripe_tomato.y + diry[i];

                if(check(next_tomato_x, next_tomato_y)){
                    queue.add(new tomato(next_tomato_x, next_tomato_y));
                    graph[next_tomato_x][next_tomato_y] = graph[ripe_tomato.x][ripe_tomato.y] + 1;
                }
            }
        }

    }

    public static boolean check(int next_x, int next_y){
        if(next_x <= -1 || next_x >= N || next_y <= -1 || next_y >= M){
            return false;
        }

        if(graph[next_x][next_y] == 0){
            return true;
        }else{
            return false;
        }
    }
}
