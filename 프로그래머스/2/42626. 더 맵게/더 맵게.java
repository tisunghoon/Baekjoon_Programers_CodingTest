import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int mixCount = 0; // 음식을 섞은 횟수

        // 1. 마법의 상자(우선순위 큐)를 만듭니다. (기본적으로 가장 작은 숫자가 맨 앞에 옵니다)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 2. 모든 음식의 스코빌 지수를 상자에 집어넣습니다.
        for (int s : scoville) {
            pq.add(s);
        }

        // 3. 상자에서 가장 덜 매운 음식(맨 앞)을 살짝 봤을 때, 그게 K보다 작다면 계속 섞어야 합니다.
        while (pq.peek() < K) {
            
            // 🚨 예외 처리: 섞어야 하는데 음식이 1개밖에 안 남았다면? 더 이상 섞을 수 없음!
            if (pq.size() == 1) {
                return -1;
            }

            // 4. 가장 덜 매운 음식 두 개를 상자에서 완전히 꺼냅니다.
            int leastSpicy = pq.poll();       // 제일 안 매운 거 (1등)
            int secondLeastSpicy = pq.poll(); // 두 번째로 안 매운 거 (2등)

            // 5. 문제의 공식대로 섞어서 새로운 음식을 만듭니다.
            int newSpicy = leastSpicy + (secondLeastSpicy * 2);

            // 6. 섞은 음식을 다시 상자에 던져 넣습니다. (알아서 자기 자리를 찾아갑니다!)
            pq.add(newSpicy);
            
            // 7. 섞은 횟수를 1 증가시킵니다.
            mixCount++;
        }

        // 반복문이 무사히 끝났다는 것은, 맨 앞의 음식이 K 이상이 되었다는 뜻입니다!
        return mixCount;
    }
}