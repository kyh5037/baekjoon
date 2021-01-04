import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Dir{
    int x;
    int y;
    Dir(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon16920 {
    static int N, M, player;
    static int dirX[] = {1, -1, 0, 0};
    static int dirY[] = {0, 0, 1, -1};
    static Queue<Dir> queue[];
    static int p_move[];
    static int board[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        player = Integer.parseInt(st.nextToken());
        queue = new LinkedList[player + 1];

        for(int i = 1; i <= player; i++){
            queue[i] = new LinkedList<>();
        }

        board = new int[N][M];
        p_move = new int[player + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= player; i++){p_move[i] = Integer.parseInt(st.nextToken());}

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                char token = str.charAt(j);
                if(token == '.'){
                    board[i][j] = 0;
                }else if(token == '#'){
                    board[i][j] = -1;
                }else{
                    if(token >= '1' && token <= '9'){
                        board[i][j] = token - '0';
                        queue[board[i][j]].add(new Dir(i, j));
                    }
                }
            }
        }

        while(true){
            int temp = 0;

            for(int i = 1; i <= player; i++){
                if(queue[i].size() == 0)
                    temp++;
            }
            if(temp == player){
                break;
            }

            for(int i = 1; i <= player; i++){
                for(int move_size = 0; move_size < p_move[i]; move_size++){    
                    
                    int queue_size = queue[i].size();
                    if(queue_size == 0) // break를 자주 쓰는 습관을 들이자.
                        break;

                    while(queue_size --> 0){
                        Dir curQueue = queue[i].poll();

                        for(int j = 0; j < dirX.length; j++){
                            int nextX = curQueue.x + dirX[j];
                            int nextY = curQueue.y + dirY[j];
                            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && board[nextX][nextY] == 0){
                                board[nextX][nextY] = i;
                                queue[i].add(new Dir(nextX, nextY));
                            } 
                        }
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= player; i++){
            int num = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(board[j][k] == i){
                        num++;
                    }
                }
            }
            sb.append(num + " ");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}
