class Solution {
    boolean solution(String s) {
        // 1. 비교를 쉽게 하기 위해 문자열을 모두 소문자로 변환합니다.
        s = s.toLowerCase();
        
        int count = 0; // 개수 차이를 기록할 변수
        
        // 2. 문자열을 한 글자씩 확인합니다.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'p') {
                count++; // p가 나오면 1 증가
            } else if (c == 'y') {
                count--; // y가 나오면 1 감소
            }
        }
        
        // 3. 카운트가 0이면 p와 y의 개수가 같음(또는 둘 다 없음)을 의미합니다.
        return count == 0;
    }
}