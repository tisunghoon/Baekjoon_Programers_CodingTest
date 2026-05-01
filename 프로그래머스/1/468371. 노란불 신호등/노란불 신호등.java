class Solution {
    public int solution(int[][] signals) {
        
        // 1. 탐색의 마지노선(최대 시간) 구하기: 모든 주기의 최소공배수(LCM)
        long maxTime = 1;
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            maxTime = lcm(maxTime, cycle);
        }
        
        // 2. 1초부터 최대 시간(최소공배수)까지 1초씩 늘려가며 완전 탐색!
        for (long t = 1; t <= maxTime; t++) {
            boolean allYellow = true; // 모든 신호등이 노란불인지 체크하는 스위치
            
            // 현재 시간(t)에 모든 신호등의 상태를 검사합니다.
            for (int[] signal : signals) {
                int g = signal[0]; // 초록불 시간
                int y = signal[1]; // 노란불 시간
                int r = signal[2]; // 빨간불 시간
                int cycle = g + y + r;
                
                // 시간 t를 주기로 나눈 나머지(m)로 현재 상태를 구합니다.
                long m = t % cycle;
                if (m == 0) m = cycle; // 딱 나누어 떨어지면, 주기의 가장 마지막 초입니다.
                
                // 노란불이 켜지는 조건: 초록불(G) 이후부터 ~ 노란불이 끝나는 시점(G+Y)까지
                if (!(g < m && m <= g + y)) {
                    allYellow = false; // 하나라도 노란불이 아니라면 탈락!
                    break; // 더 이상 다른 신호등을 검사할 필요 없이 반복문을 빠져나갑니다.
                }
            }
            
            // 모든 신호등을 통과해서 allYellow가 여전히 true라면? 정답 발견!
            if (allYellow) {
                return (int) t;
            }
        }
        
        // 3. 최소공배수 시간까지 모두 확인했는데도 정답이 없다면 영원히 없는 것입니다.
        return -1;
    }

    // 🛠️ 보조 무기 1: 최대공약수(GCD)를 구하는 함수 (유클리드 호제법)
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 🛠️ 보조 무기 2: 최소공배수(LCM)를 구하는 함수
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}