package doit.hsk;

import java.util.Scanner;

// 배열 요소의 최대값을 나타낸다(값을 입력 받음)
public class MaxOfArray {

	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최대값을 구한다.");
		System.out.println("사람 수 : ");
		int num = stdIn.nextInt();
		
		int[] height = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.println("height["+ i + "] : ");
			height[i] = stdIn.nextInt();
		}
		System.out.println(maxOf(height));
	}
	
}
