package doit.hsk;

import java.util.Scanner;

// 2자리의 양수(10~99)를 입력한다.
public class Digits {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in); 
		int no;
		
		System.out.println("");
		
		do {
			System.out.print("입력");
			no = stdIn.nextInt();
		} while(no < 10 || no > 99);
		
		System.out.println(no);
	}
}
