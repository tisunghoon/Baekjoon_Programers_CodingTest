class Solution {
    public long solution(int price, int money, int count) {
        // 총 필요한 요금을 저장할 변수 (int 범위를 넘을 수 있으므로 long 사용)
        long totalCost = 0;
        
        // 1번부터 count번까지 탈 때의 요금을 누적해서 더함
        for (int i = 1; i <= count; i++) {
            totalCost += (long) price * i;
        }
        
        // 부족한 금액 계산 (총 비용 - 가진 돈)
        long shortfall = totalCost - money;
        
        // 돈이 부족하지 않으면(shortfall이 0 이하이면) 0을 반환하고, 부족하면 그 금액을 반환
        return Math.max(0, shortfall);
    }
}