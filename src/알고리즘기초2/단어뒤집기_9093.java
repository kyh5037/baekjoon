package 알고리즘기초2;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기_9093 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		char[] arr = null;
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < num; i++) {
			Stack<Character> stack = new Stack<Character>();
			String string = sc.nextLine();
			for (int j = 0; j < string.length(); j++) {
				if(string.charAt(j) == ' ') {
					while(!stack.empty()) {
						// System.out.print(stack.pop());
						arr[j] = stack.pop();
					}
					//System.out.print(" ");
				} else {
					stack.push(string.charAt(j));
				}	
			}
			
			while(!stack.empty()) {
				// System.out.print(stack.pop());
				arr[i] = stack.pop();
			}
			System.out.println();
		}
	}
}
