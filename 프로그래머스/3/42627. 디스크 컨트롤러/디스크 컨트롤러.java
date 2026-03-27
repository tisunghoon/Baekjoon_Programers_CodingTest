import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시간이 빠른 순서대로 배열을 정렬합니다. (시간의 흐름에 따라 작업을 보기 위해)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 2. 대기열(우선순위 큐): '소요 시간'이 짧은 순서대로 정렬되는 마법의 상자
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int currentTime = 0;       // 하드디스크의 현재 시간
        int completedJobs = 0;     // 완료된 작업의 개수
        int totalResponseTime = 0; // 각 작업의 (종료 시간 - 요청 시간) 총합
        int jobsIdx = 0;           // jobs 배열에서 다음으로 대기열에 넣을 작업의 인덱스

        // 3. 모든 작업이 끝날 때까지 반복합니다.
        while (completedJobs < jobs.length) {
            
            // 핵심 1: 현재 시간(currentTime)과 같거나 그 이전에 도착한 모든 작업을 대기열(PQ)에 넣습니다.
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= currentTime) {
                pq.add(jobs[jobsIdx]);
                jobsIdx++;
            }

            // 대기열에 작업이 있다면? (가장 빨리 끝나는 작업부터 처리)
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll(); // 대기열에서 1등 꺼내기
                
                // 시간 흐름 처리
                currentTime += currentJob[1]; 
                
                // (현재 시간 - 이 작업이 처음 요청된 시간)을 정답에 누적
                totalResponseTime += currentTime - currentJob[0]; 
                
                completedJobs++; // 완료 처리
            } 
            // 대기열이 비어있다면? (하드디스크가 멍때리며 쉬고 있는 상태)
            else {
                // 핵심 2: 시간을 1초씩 더하지 않고, 다음 작업이 들어오는 시간으로 워프(Warp)합니다!
                currentTime = jobs[jobsIdx][0];
            }
        }

        // 평균 시간을 구하여 소수점 이하를 버리고(정수 나눗셈) 반환합니다.
        return totalResponseTime / jobs.length;
    }
}