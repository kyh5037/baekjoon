import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Command{
    int sec;
    String dir;

    Command(int sec, String dir){
        this.sec = sec;
        this.dir = dir;
    }
}

class Location{
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class baekjoon3190 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Command> c_queue = new LinkedList<>();

        int board_size = Integer.parseInt(br.readLine());
        int board[][] = new int[board_size][board_size];

        int apple = Integer.parseInt(br.readLine());
        for(int i = 0; i < apple; i++){
            String[] apple_loc = br.readLine().split(" ");
            int row = Integer.parseInt(apple_loc[0]) - 1;
            int col = Integer.parseInt(apple_loc[1]) - 1;

            board[row][col] = -1;
        }


        Queue<Location> snake = new LinkedList<>();
        snake.offer(new Location(0, 0));
        board[0][0] = 1;
        int move = Integer.parseInt(br.readLine());
        for(int i = 0; i < move; i++){
            String[] snake_mov = br.readLine().split(" ");
            c_queue.offer(new Command(Integer.parseInt(snake_mov[0]), snake_mov[1]));
        }

        int row = 0;
        int col = 0;
        int time = 0;

        String dir = "R";
        int be_row = 0;
        int be_col = 0;
        while(true){
            
            switch(dir){
            case "U":
                row--;
                break;
            case "D":
                row++;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
            }

            time++;

            if((row >= 0 && row < board_size) && (col >= 0 && col < board_size)){
                
                if(board[row][col] == 1)
                    break;

                if(board[row][col] == -1){
                    board[row][col] = 1;
                    snake.add(new Location(row, col));
                }else{
                    board[row][col] = 1;
                    board[be_row][be_col] = 0;
                    
                    snake.poll();
                    snake.add(new Location(row, col));

                    if(snake.size() > 1){
                        be_row = snake.peek().x;
                        be_col = snake.peek().y;
                    } else {
                        be_row = row;
                        be_col = col;
                    }
                }

                if(!c_queue.isEmpty()){
                    if(c_queue.peek().sec == time){
                        
                        String c_move = c_queue.poll().dir;
                        switch(dir){
                        case "U":
                            if(c_move.equals("L")){
                                dir = "L";
                            }else{
                                dir = "R";
                            }
                            break;
                        case "D":
                            if(c_move.equals("L")){
                                dir = "R";
                            } else {
                                dir = "L";
                            }
                            break;
                        case "L":
                            if(c_move.equals("L")){
                                dir = "D";
                            } else {
                                dir = "U";
                            }
                            break;
                        case "R":
                            if(c_move.equals("L")){
                                dir = "U";
                            } else {
                                dir = "D";
                            }
                            break;
                        }
                    }
                }
            } else
                break;
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
}
