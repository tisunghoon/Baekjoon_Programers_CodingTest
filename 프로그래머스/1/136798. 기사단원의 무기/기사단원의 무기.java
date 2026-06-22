class Solution {
    public int solution(int number, int limit, int power) {
        int totalIron = 0;
        
        // 1번 기사부터 number 기사까지 순회
        for (int i = 1; i <= number; i++) {
            int divisorCount = getDivisorCount(i); // 현재 기사 번호의 약수 개수 구하기
            
            // 제한수치(limit)를 초과하는 경우 지정된 무기(power) 사용
            if (divisorCount > limit) {
                totalIron += power;
            } else {
                // 초과하지 않으면 약수 개수 그대로 사용
                totalIron += divisorCount;
            }
        }
        
        return totalIron;
    }
    
    // 효율적으로 약수의 개수를 구하는 헬퍼 메서드
    private int getDivisorCount(int n) {
        int count = 0;
        
        // 제곱근까지만 반복 (i * i <= n)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i는 약수
                
                // n / i 도 약수이므로 카운트 증가 (단, i * i == n 인 경우 중복 방지)
                if (i * i != n) {
                    count++;
                }
            }
        }
        
        return count;
    }
}