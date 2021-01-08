import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] average = new int[4];
        int[] count = new int[8001];
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i] + 4000]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] > max){
                max = count[i];
            }
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == max)
                list.add(i-4000);
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < num; i++){
            sum += arr[i];
        }

        average[0] = ((int)Math.round((double)sum/num));
        average[1] = arr[num/2];
        if(list.size() == 1){
            average[2] = list.get(0);
        }else{
            Collections.sort(list);
            average[2] = list.get(1);
        }
        average[3] = (arr[num - 1] - arr[0]);

        for(int i : average){
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}
