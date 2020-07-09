package 알고리즘기초;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			String[] str = br.readLine().split(" ");
			
			switch(str[0]) {
			case "push":
				stack.push(Integer.parseInt(str[1]));
				break;
			case "pop":
				if(stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					bw.write(stack.pop()+ "\n");
				}
				break;
			case "size":
				bw.write(stack.size() + "\n");
				break;
			case "empty":
				if(stack.empty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
				break;
			case "top":
				if(stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					bw.write(stack.peek() + "\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}
