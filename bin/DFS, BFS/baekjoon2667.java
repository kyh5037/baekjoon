import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon2667 {
    static int[][] graph;
    static int num;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        graph = new int[num][num];
        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < num; j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                cnt = 0;
                if(dfs(i, j)){
                    count++;
                    arr.add(cnt);
                }
            }
        }

        Collections.sort(arr);

        System.out.println(count);

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static boolean dfs(int x, int y){
        
        if(x <= -1 || x >= num || y <= -1 || y >= num){
            return false;
        }

        if(graph[x][y] == 1){
            graph[x][y] = 0;
            cnt++;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        
        return false;
    }

    
}
