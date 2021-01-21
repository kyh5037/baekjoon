import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class knight{
    int x;
    int y;
    knight(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon7562 {
    static BufferedReader br;
    static int[] dirX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dirY = {2, 1, -1, -2, -2, -1, 1, 2};
    static int size;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        int[] answer = new int[test_case];

        for(int i = 0; i < test_case; i++){
            answer[i] = bfs();
        }
        

        for(int i : answer){
            bw.write(String.valueOf(i) + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static int bfs() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Queue<knight> queue = new LinkedList<>();

        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        visited = new boolean[size][size]; 

        String[] start = br.readLine().split(" ");
        int start_x = Integer.parseInt(start[0]);
        int start_y = Integer.parseInt(start[1]);
        
        String[] end = br.readLine().split(" ");
        int end_x = Integer.parseInt(end[0]);
        int end_y = Integer.parseInt(end[1]);

        queue.offer(new knight(start_x, start_y));
        graph[start_x][start_y] = 0;

        while(!queue.isEmpty()){
            knight knight = queue.poll();

            for(int i = 0; i < dirX.length; i++){
                int next_x = knight.x + dirX[i];
                int next_y = knight.y + dirY[i];

                if(check(next_x, next_y)){
                    queue.add(new knight(next_x, next_y));
                    visited[next_x][next_y] = true;
                    graph[next_x][next_y] = graph[knight.x][knight.y] + 1;
                }
            }

            if(knight.x == end_x && knight.y == end_y){
                return graph[end_x][end_y];
            }else if(start_x == end_x && start_y == end_y){
                return 0;
            }
        }

        return 0;
    }

    public static boolean check(int x, int y){

        if(x >= 0 && x < size && y >= 0 && y < size && !visited[x][y]){
            return true;
        } else{
            return false;
        }
    }
}
