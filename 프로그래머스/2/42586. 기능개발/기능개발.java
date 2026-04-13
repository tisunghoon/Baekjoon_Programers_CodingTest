import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        // 첫 번째 기능이 완료되는 날을 초기 기준일로 설정
        int maxDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            // 현재 기능의 소요 시간 계산 (올림 처리 공식)
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (day <= maxDay) {
                // 현재 기능이 기준일보다 빨리 끝나면 같은 배포 그룹
                count++;
            } else {
                // 기준일보다 늦게 끝나면 이전 그룹을 배포하고 새 기준일 설정
                answer.add(count);
                count = 1;
                maxDay = day;
            }
        }
        
        // 마지막으로 쌓인 그룹 배포
        answer.add(count);

        // List를 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}