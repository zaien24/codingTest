class Solution {

    public String push(char c, int n) {

        if (!Character.isAlphabetic(c)) { return c;}

        int offset = Character.isUppercase(c) ? 'A' : 'a';
        int position = c - offset;
        int tmp = (position + n) % 26;
        String result = tmp + offset;

        return result;
    }

    public String solution(String s, int n) {
        // 밀기
        // 공백 처리 
        // 1~ 25
        // z -> a
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(push(c, n));
        }

        return sb.toString();
    }
}