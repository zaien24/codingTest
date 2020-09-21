package doit.hsk;

import java.util.Scanner;

public class SumFor {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구한다.");
		System.out.print("n의 값 : ");
		int n = stdIn.nextInt();
		
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}

}
