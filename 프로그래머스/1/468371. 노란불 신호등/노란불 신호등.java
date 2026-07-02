class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] cycle = new int[n];      // 각 신호등의 한 주기 길이 G+Y+R
        long lcm = 1;
        for (int i = 0; i < n; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = lcm / gcd(lcm, cycle[i]) * cycle[i];   // 전체 반복 주기
        }

        for (long t = 1; t <= lcm; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int pos = (int) ((t - 1) % cycle[i]);    // 1초 시작·초록불 시작 오프셋
                int g = signals[i][0], y = signals[i][1];
                if (pos < g || pos >= g + y) {           // 노란불 구간 [g, g+y) 밖
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return (int) t;               // 모두 노란불인 최초 시각
        }
        return -1;                                       // 한 주기 내 없으면 영원히 없음
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}