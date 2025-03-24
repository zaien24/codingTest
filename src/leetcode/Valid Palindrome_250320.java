class Solution {
    StrinBuilder sb =  new StringBuilder();
    public boolean isPalindrome(String s) {
        boolean result = false;
        for (char ch : s.toCharArray()) {
            if (ch.isAlphabetic()) {
                sb.append(Character.isLowerCase(ch));
            }
        }
        if (sb.toString() ==?) {
            result = true;
        } 
        return result;
    }
}
//문제 > 시간,메모리 > 입출력 > 문제분석 > 완전탐색 시간복잡도 > 최대치 > 자료구조, 알고리즘 선택 > 코딩
//클린, 자동차 디자인패턴(확장, 유용, 객체지향, SOLID), 시간복잡도

//입출력
// 입력 :문자열 2* 100000
// 출력 : boolean 

//?ASCII characters 
//printable 

//문제분석
//isAlphabetic();
// 완전 탐색 
// 대문자 -> 소문자로 바뀌기 isLowerCase();
//Character 

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 왼쪽 문자가 알파벳 또는 숫자 아니면 이동
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // 오른쪽 문자가 알파벳 또는 숫자가 아니면 이동
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // 대소문자를 구분하지 않기 위해 소문자로 변환 후 비교 
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }

        return true;
            
    }
}






class Solution {
    public boolean isPalindrome(String s) {
        //투포인터
        // left, right 
        // 숫자, 문자 가 아닐경우 
        // 소문자일 경우 대소문자 비교 
        // isLetterOrDigit();
        // isLowerCase();
        if (s == null || s.isEmpty()) return false; 
        int left = 0;
        int right = s.length() -1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }
}