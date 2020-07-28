package if문;

import java.util.Scanner;

public class 두수비교_1330번 {
	public static void main(String[] args) {
		int a, b = 0;
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a < b)
			System.out.println("<");
		else if(a > b)
			System.out.println(">");
		else
			System.out.println("==");
	}
}
