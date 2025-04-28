import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        // 1. magazine의 문자 개수를 세기
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        } 

        // 2. ransomNote의 문자가 magazine에 있는지 체크
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0 ) {
                return false; // 없는 문자거나 다 써버린 경우
            }
            map.put(c, map.get(c) - 1); // 하나 사용했으니까 줄이기
        }

        return true; // 전부 만족했으면 true       
    }
}