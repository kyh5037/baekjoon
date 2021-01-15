import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2606 {
    static int[][] graph;
    static boolean[] checked;
    static int computer, network;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());
        graph = new int[computer + 1][computer + 1];
        checked = new boolean[computer + 1];

        StringTokenizer st;
        for(int i = 0; i < network; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;           
        }

        count = 0;
        bfs();

        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        checked[1] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            
            for(int i = 1; i <= computer; i++){
                if(graph[temp][i] == 1 && checked[i] == false){
                    queue.offer(i);
                    checked[i] = true;
                    count++;
                }
            }
        }
    }
}
