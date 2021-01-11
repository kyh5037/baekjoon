import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hm = new HashMap<>();

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
            String str = br.readLine();
            hm.put(str, str.length());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2){
                if(obj1.getValue() == obj2.getValue()){
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> map : list){
            sb.append(map.getKey() + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
