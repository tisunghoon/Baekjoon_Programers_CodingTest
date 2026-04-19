class Solution {
    public int solution(int a, int b) {
        
        // 1. a 뒤에 b를 붙여서 숫자로 변환
        // 빈 문자열("")에 a와 b를 차례대로 더하면 "ab" 형태의 문자열이 됩니다.
        int ab = Integer.parseInt("" + a + b);
        
        // 2. b 뒤에 a를 붙여서 숫자로 변환
        int ba = Integer.parseInt("" + b + a);
        
        // 3. 두 숫자 중 더 큰 값을 반환합니다!
        return Math.max(ab, ba);
    }
}