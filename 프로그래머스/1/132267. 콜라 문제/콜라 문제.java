class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            // 이번 턴에 받는 콜라 수
            int newColas = (n / a) * b;
            answer += newColas;
            
            // 다음 턴에 쓸 빈 병 수 업데이트
            n = (n % a) + newColas;
        }
        
        return answer;
    }
}