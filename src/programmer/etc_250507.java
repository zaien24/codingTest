import java.util.*;

class Solution {
    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();

        Set<Character> visited = new HashSet<>();            // 이미 한 번 이상 나온 문자
        Set<Character> result = new HashSet<>();             // 외톨이 알파벳 후보   

        char prev = input_string.charAt(0);            // 첫 글자로 초기화
        visited.add(prev);                                   // 첫 글자 방문 처리

        for (int i = 1; i < input_string.length(); i++) {
            char curr = input_string.charAt(i);

            if (prev != curr) {
                if (visited.contains(curr)) {
                    result.add(curr);                        // 떨어져서 다시 나온 알파벳
                } else {
                    visited.add(curr);                       // 처음 등장한 알파벳
                }
            }
            prev = curr;
        }

        if (result.isEmpty()) return "N";

        // 사전 순 정렬
        List<Character> list = new ArrayList<>(result);
        Collections.sort(list);

        for (char ch : list) {
            sb.append(ch);
        }

        return sb.toString();
    }
}