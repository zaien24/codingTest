class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        String tmp = Long.toString(n);
        sb.append(tmp);
        tmp = sb.reverse().toString();

        // 출력 
        char[] ch = tmp.toCharArray();
        int[] nums = new int[ch.length];
        // for (char ch : tmp.toCharArray()) {
        //     nums[i] = ch + '0'
        // }
        for (int i = 0; i < ch.length; i++) {
            nums[i] = ch[i] + '0';
        }

        return nums;
    }
}

// 시간, 메모리 
// 입력 : long n
// 출력 : 배열 숫자로 구성
// 뒤집어
// 최대치
// 알고리즘~

