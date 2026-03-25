import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 1. 바위들을 출발지점부터 순서대로 서게 만들기 위해 오름차순 정렬합니다.
        Arrays.sort(rocks);

        int left = 1; 
        int right = distance; 
        int answer = 0;

        // 2. 이분 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2; // mid: 우리가 테스트해 볼 "바위 간의 최소 거리"
            
            int removeCount = 0; // 치운 바위의 개수
            int prev = 0;        // 이전 바위의 위치 (처음엔 출발지점 0)

            // 3. 바위들을 하나씩 확인하며 치울지 말지 결정합니다.
            for (int i = 0; i < rocks.length; i++) {
                // 현재 바위와 이전 바위 사이의 거리가 기준치(mid)보다 짧다면?
                if (rocks[i] - prev < mid) {
                    removeCount++; // 기준 미달이므로 바위를 치웁니다.
                } else {
                    // 거리가 기준치 이상이라면 바위를 살려두고, 현재 바위를 이전 바위로 업데이트!
                    prev = rocks[i]; 
                }
            }

            // 4. 마지막으로 남은 바위와 도착지점(distance) 사이의 거리도 확인해야 합니다!
            if (distance - prev < mid) {
                removeCount++;
            }

            // 5. 조건 판별 및 범위 좁히기
            if (removeCount > n) {
                // n개보다 더 많이 치웠다면, 우리가 정한 최소 거리(mid)가 너무 크다는 뜻입니다.
                right = mid - 1; 
            } else {
                // n개 이하로 치웠다면 조건 만족! (n개를 딱 맞추지 않아도, 덜 치운 상태에서 더 치우면 되므로 만족하는 것입니다)
                answer = mid; // 일단 정답 후보로 저장해 둡니다.
                left = mid + 1; // "최댓값"을 찾기 위해 거리를 더 늘려봅니다.
            }
        }

        return answer;
    }
}