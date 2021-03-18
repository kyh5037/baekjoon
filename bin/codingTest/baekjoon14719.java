package baekjoon.bin.codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14719 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            int block = Integer.parseInt(st.nextToken());
            arr[i] = block;
        }

        int right, left, current = 0;
        for(int i = 1; i < W - 1; i++){
            left = right = 0;
            for(int j = 0; j < i; j++){
                left = Math.max(arr[j], left);
            }
            for(int j = i + 1; j < W; j++){
                right = Math.max(arr[j], right);
            }

            if(arr[i] < left && arr[i] < right){
                current += (Math.min(right, left) - arr[i]);
            }
        }

        System.out.println(current);
    }
}
