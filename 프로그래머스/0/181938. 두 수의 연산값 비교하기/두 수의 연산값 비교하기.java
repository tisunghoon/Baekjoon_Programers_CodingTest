class Solution {
    public int solution(int a, int b) {
        
        // 1. 후보 1: a와 b를 문자열로 이어 붙인 뒤 다시 숫자로 변환합니다.
        int ab = Integer.parseInt("" + a + b);
        
        // 2. 후보 2: 수학적인 곱셈 연산을 수행합니다.
        int math = 2 * a * b;
        
        // 3. 두 값 중 더 큰 값을 반환합니다!
        return Math.max(ab, math);
    }
}