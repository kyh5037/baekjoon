import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon1012 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int M, N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        int[] answer = new int[test_case];

        for(int i = 0; i < test_case; i++){
            answer[i] = test();
        }

        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    public static int test() throws IOException {
        String[] string = br.readLine().split(" ");
        M = Integer.parseInt(string[0]);
        N = Integer.parseInt(string[1]);
        int K = Integer.parseInt(string[2]);

        graph = new int[M][N];
        

        for(int i = 0; i < K; i++){
            String[] cabbage = br.readLine().split(" ");
            int cabbage_x = Integer.parseInt(cabbage[0]);
            int cabbage_y = Integer.parseInt(cabbage[1]);

            graph[cabbage_x][cabbage_y] = 1;
        }

        int count = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(dfs(i, j)){
                    count++;
                }
            }
        }
        
        return count;
    }

    public static boolean dfs(int x, int y){
        if(x <= -1 || x >= M || y <= -1 || y >= N){
            return false;
        }

        if(graph[x][y] == 1){
            graph[x][y] = 0;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        
        return false;
    }
}
