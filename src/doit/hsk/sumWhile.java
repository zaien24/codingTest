package doit.hsk;

import java.util.Scanner;

public class sumWhile {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구한다.");
		System.out.print("n의 값 : ");
		int n = stdIn.nextInt();
		
		int sum = 0; // 합
		int i = 1; 
				
		while (i <= n) { 
			sum += i;
			i++;
		}
		System.out.println(sum);
	}

}
