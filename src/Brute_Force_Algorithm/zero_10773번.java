package Brute_Force_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class zero_10773번 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num, sum = 0;
		
		int count = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < count; i++) {
			num = Integer.parseInt(br.readLine());
			
			if (num == 0 && !stack.isEmpty())
				stack.pop();
			else
				stack.push(num);
		}
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
