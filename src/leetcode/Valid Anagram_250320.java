class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // 길이가 다르면 아나그램이 아님.
        
        HashMap<Character, Integer> charCount = new HashMap<>();

        // 첫 번째 문자열의 문자 빈도수 증가
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) +1);
        }

        // 두 번째 문자열의 문자 빈도수 감소
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) return false; // 없는 문자가 나오면 아나그램 안님
            charCount.put(c, charCount.get(c)-1);
            if (charCount.get(c) == 0) charCount.remove(c); // 개수가 0이면 삭제  
        }

        return charCount.isEmpty(); // 모든 문자가 동일하게 사용되었으면 true
    }
}