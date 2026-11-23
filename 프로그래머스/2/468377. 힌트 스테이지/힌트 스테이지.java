class Solution {
    private int n;
    private int[][] cost;
    private int[][] hint;
    private int[] counts;
    private int[] suffixMin;
    private int minCost;

    public int solution(int[][] cost, int[][] hint) {
        this.n = cost.length;
        this.cost = cost;
        this.hint = hint;
        this.counts = new int[n];
        this.suffixMin = new int[n + 1];
        this.minCost = Integer.MAX_VALUE;

        // 남은 스테이지에서 들 수 있는 이론상 최소 비용(하한) 미리 계산
        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = suffixMin[i + 1] + cost[i][n - 1];
        }

        dfs(0, 0);
        return minCost;
    }

    private void dfs(int idx, int curCost) {
        // 남은 스테이지를 모두 최저 비용으로 해결해도 현재 최솟값 이상이면 중단
        if (curCost + suffixMin[idx] >= minCost) {
            return;
        }

        // 마지막 스테이지는 번들 판매가 없으므로 해결 비용만 더하고 최솟값 갱신
        if (idx == n - 1) {
            int total = curCost + cost[idx][Math.min(counts[idx], n - 1)];
            if (total < minCost) {
                minCost = total;
            }
            return;
        }

        // 현재 스테이지(idx)에 사용할 힌트권 수는 이후 번들의 영향을 받지 않으므로 확정됨
        int nextCost = curCost + cost[idx][Math.min(counts[idx], n - 1)];

        // 1. 현재 스테이지 힌트 번들을 구매하지 않는 경우
        dfs(idx + 1, nextCost);

        // 2. 현재 스테이지 힌트 번들을 구매하는 경우
        int[] bundle = hint[idx];
        int buyCost = nextCost + bundle[0];
        if (buyCost + suffixMin[idx + 1] < minCost) {
            for (int j = 1; j < bundle.length; j++) {
                counts[bundle[j] - 1]++;
            }
            dfs(idx + 1, buyCost);
            for (int j = 1; j < bundle.length; j++) {
                counts[bundle[j] - 1]--;
            }
        }
    }
}