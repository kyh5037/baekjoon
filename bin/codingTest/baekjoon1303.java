package baekjoon.bin.codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location_1303{
    int x;
    int y;
    location_1303(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon1303 {
    public static char graph[][];
    public static boolean check[][];
    public static int N, M;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int white, blue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        check = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        bfs();
    }

    public static void bfs(){
        Queue<location_1303> queue = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!check[i][j]){
                    queue.offer(new location_1303(i, j));
                    check[i][j] = true;
                    int ans = 1;
                    while(!queue.isEmpty()){
                        location_1303 temp = queue.poll();
                        int x = temp.x;
                        int y = temp.y;
                        for(int k = 0; k < 4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(!check[nx][ny] && graph[nx][ny] == graph[i][j]){
                                queue.offer(new location_1303(nx, ny));
                                check[nx][ny] = true;
                                ans++;
                            }
                        }
                    }
                    if(graph[i][j] == 'W') white += (ans * ans);
                    else blue += (ans * ans);
                }
            }
        }

        System.out.println(white + " " + blue);
    }
}
