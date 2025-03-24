//문제 > 시간,메모리 > 입출력 > 문제분석 > 완전탐색 시간복잡도 > 최대치 > 자료구조, 알고리즘 선택 > 코딩
//클린, 자동차 디자인패턴(확장, 유용, 객체지향, SOLID), 시간복잡도


class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1;  j < prices.length; j++) {
                if (prices[i] < prices[j] && max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
            }
        }

        return max;    
    }
}
//입력 -> int[]
//출력 -> int
// prices[i] 10000
// 100000
// 문제분석
// 1 ~ ...... 
// 완전탐색 시간복잡도 N'2
// 자료구조 



//
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE; // 최소 매수가격
        int maxProfit = 0; // 최대 이익

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // 더 낮은 가격 발견 시 매수가격 업데이트
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // 현재 가격에서 판매한 경우의 최대 이익 계산
            }
        }

        return maxProfit;
    }


    
}
































