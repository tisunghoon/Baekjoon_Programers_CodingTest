import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 오름차순으로 자동 정렬되는 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            // 1. 오늘의 점수를 명예의 전당 큐에 추가
            pq.add(score[i]);
            
            // 2. 명예의 전당 정원(k)을 초과한 경우, 가장 낮은 점수를 밀어냄(제거)
            if (pq.size() > k) {
                pq.poll();
            }
            
            // 3. 현재 명예의 전당 커트라인(가장 낮은 점수)을 정답 배열에 기록
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}