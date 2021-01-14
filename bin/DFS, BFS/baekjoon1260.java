import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260 {
    static int[][] graph;
    static boolean[] visited;
    static int vertex, edge, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");
        vertex = Integer.parseInt(num[0]);
        edge = Integer.parseInt(num[1]);
        start = Integer.parseInt(num[2]);

        visited = new boolean[vertex + 1];
        graph = new int[vertex + 1][vertex + 1];

        StringTokenizer st;
        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
        
        dfs(start);
        visited = new boolean[vertex + 1];
        System.out.println();
        bfs(start);
    }

    public static void dfs(int start){
        if(visited[start])
            return;
        
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= vertex; i++){
            if(graph[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 1; i <= vertex; i++){
                if(graph[temp][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
