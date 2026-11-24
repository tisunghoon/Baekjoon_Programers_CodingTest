import java.util.*;

class Solution {
    private int n;
    private int maxInfected;
    private List<Integer>[][] adj;

    @SuppressWarnings("unchecked")
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.maxInfected = 1;
        this.adj = new ArrayList[4][n + 1];

        for (int t = 1; t <= 3; t++) {
            for (int i = 1; i <= n; i++) {
                adj[t][i] = new ArrayList<>();
            }
        }

        // 파이프 타입(1: A, 2: B, 3: C)별로 무방향 그래프 구성
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            adj[type][x].add(y);
            adj[type][y].add(x);
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, k, 0, infected, 1);
        return maxInfected;
    }

    private void dfs(int depth, int k, int lastType, boolean[] infected, int count) {
        maxInfected = Math.max(maxInfected, count);
        if (depth == k || maxInfected == n) {
            return;
        }

        for (int type = 1; type <= 3; type++) {
            if (type == lastType) continue;

            boolean[] nextInfected = infected.clone();
            Deque<Integer> queue = new ArrayDeque<>();

            // 현재 감염된 노드 중 해당 타입 파이프와 연결된 노드만 시작점으로 추가
            for (int i = 1; i <= n; i++) {
                if (nextInfected[i] && !adj[type][i].isEmpty()) {
                    queue.offer(i);
                }
            }

            // 열린 파이프를 통해 연결된 모든 배양체로 연쇄 감염 (BFS)
            int nextCount = count;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : adj[type][curr]) {
                    if (!nextInfected[next]) {
                        nextInfected[next] = true;
                        nextCount++;
                        queue.offer(next);
                    }
                }
            }

            // 새로 감염된 노드가 있을 때만 다음 단계로 진행
            if (nextCount > count) {
                dfs(depth + 1, k, type, nextInfected, nextCount);
                if (maxInfected == n) return;
            }
        }
    }
}