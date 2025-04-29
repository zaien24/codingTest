package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // 문자 개수 세기
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1 );
        }

        int length = 0;
        boolean hasOdd = false;

        // 개수에 따라 길이 계산
        for (int count : map.values() ) {
            if (count % 2 == 0) {
                length += count; // 짝수면 전부 사용
            } else {
                length += count -1; // 홀수면 하나 빼고 짝수만 사용
                hasOdd = true; // 그리고 홀수 있음 표시
            }
        }

        if (hasOdd) {
            length += 1;    // 가운데 하나 추가 가능
        }

        return length;
    }
}