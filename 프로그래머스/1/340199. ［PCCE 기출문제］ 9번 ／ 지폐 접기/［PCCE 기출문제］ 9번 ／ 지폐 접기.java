class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지폐를 회전했을 때를 고려하여, 작은 변끼리 비교하고 큰 변끼리 비교합니다.
        // 지폐의 변이 지갑의 변보다 하나라도 크다면 계속 접어야 합니다.
        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || 
               Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
            
            // 항상 지폐의 길이가 더 긴 쪽을 반으로 접습니다.
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            // 접은 횟수 증가
            answer++;
        }
        
        return answer;
    }
}