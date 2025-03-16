class Solution {
    public int solution(String s) {
        int min = s.length();

        for (int len = 1; len < s.length() / 2; len++) {
            int compressedLength = compress(s, len);
            min = Math.min(min, compressedLength);
        }

        return min;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = source.substring(0, length);
        int count = 1;

        for (int i = length; i <= source.length(); i += length) {
            String next;

            if (i + length > source.length()) {
                next = source.subtring(i);
            } else {
                next = source.substring(i, i + length);
            }

            if (next.equals(last)) {
                count++; 
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = next;
                count = 1; 
            }
        }

        // 마지막 문자열 처리 
        if (count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }
}