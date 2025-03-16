class Solution {

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length; 
            if (endInex > source.length()) {
                endInex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }

        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1; 
            }
        }
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }
}

//시간, 메모리
// 입력 : 문자
// 출력 : 숫자 가장 짧은 것의 길이 

// 1개 이상의 단위로 잘라서
// 2개 단위로 잘라서 압축
// 8개 단위로 잘라서 압축
// 문자열 제일 앞부터 정해진 길이만큼 잘라야 한다. 
// 2a2ba3c 7개
// 2ababcdcd

//boolean 활용 
// s = 1000 
//500 부터 내려온다. 
//시간 초과. 