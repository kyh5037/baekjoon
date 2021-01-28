import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class programmers_false {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] arr = solution(N, stages);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();

        int count = 0;
        int temp = stages.length;
        for(int i = 1; i <= N; i++){
            temp -= count;
            count = 0;
            for(int j = 0; j < stages.length; j++){
                if(i == stages[j]){
                    count++;
                }
            }
            Double failure_rate = count / (double)temp;
            map.put(i, failure_rate);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        int[] answer = new int[N];

        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        for(int i = 0; i < answer.length; i++){
            answer[i] = keySetList.get(i);
        }
    
        return answer;
    }
}
