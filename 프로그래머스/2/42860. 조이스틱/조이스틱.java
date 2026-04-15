class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        // 커서 이동의 기본값: 오른쪽으로 쭉 끝까지 가는 횟수
        int move = length - 1; 

        for (int i = 0; i < length; i++) {
            
            // 1. 위/아래 조작 횟수 계산 (알파벳 맞추기)
            char c = name.charAt(i);
            // 'A'에서 위로 조작하는 횟수 vs 'A'에서 아래로 조작하는 횟수
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 왼쪽/오른쪽 조작 횟수 계산 (커서 이동 최소화)
            int next = i + 1;
            
            // 현재 위치(i) 다음부터 시작해서, 연속된 'A'가 끝나는 지점(next) 찾기
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 경로 최적화 비교 (현재까지의 최소 move vs 새로운 경로들)
            
            // 경로 B: 오른쪽으로 i만큼 갔다가, 다시 왼쪽으로 돌아가서 next부터 끝까지 처리
            // 이동 거리: (오른쪽으로 i) + (왼쪽으로 i 돌아옴) + (맨 뒤에서 next까지 이동거리)
            int pathB = (i * 2) + (length - next);
            
            // 경로 C: 처음부터 왼쪽으로 돌아가서 next부터 끝까지 치고, 다시 오른쪽으로 와서 i까지 처리
            // 이동 거리: (맨 뒤에서 next까지 이동) + (다시 맨 뒤로 돌아감) + (오른쪽으로 i까지 이동)
            int pathC = ((length - next) * 2) + i;
            
            // 가장 짧은 이동 거리를 move에 갱신
            move = Math.min(move, Math.min(pathB, pathC));
        }

        // 총 조작 횟수 = 알파벳 변경 횟수 + 커서 이동 횟수
        answer += move;
        
        return answer;
    }
}