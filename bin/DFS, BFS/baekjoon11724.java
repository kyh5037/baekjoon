import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11724 {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        graph = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[N+1];
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i] == false){
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
        
    }

    public static void dfs(int a){
        if(visited[a] == true){
            return;
        }else{
            visited[a] = true;
            for(int i = 1; i <= N; i++){
                if(graph[a][i] == 1){
                    dfs(i);
                }
            }
        }
    }
}
