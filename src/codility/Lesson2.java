package codility;

import java.util.ArrayList;

public class Lesson2 {

	public static void main(String[] args) {
		 
		int[] A = {3,8,9,7,6};
		int K = 3;
		
		System.out.println(solution(A, 3));
	}
	
	public static int[] solution(int[] A, int K) {
		// 1. 배열 받아오기

		int length = A.length;
        
        if (length > 0) {
            // 2. K만큼 회전
            /*for (int i=0; i<K;i++) {
                int last = A[length - 1];
                for (int j=length-1; j>0; j--) {
                    A[j] = A[j-1];
                }
                A[0] = last;
            }*/
        	for (int i=0; i<K; i++) {
        		int last = A[length - 1];        		
        		for (int j = length-1; j>0; j--) {
        			A[j] = A[j-1];
        		}
        		A[0] = last;
        	}
        }
        return A;
	}
	
}
