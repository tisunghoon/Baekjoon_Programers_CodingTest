class Solution {
    public String solution(String number, int k) {
        // 1. 숫자를 차곡차곡 쌓을 정답 상자 (스택 역할)
        StringBuilder answer = new StringBuilder();

        // 2. 주어진 숫자를 처음부터 끝까지 하나씩 확인합니다.
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i); // 이번 턴에 상자에 넣을 숫자

            // 3. 탐욕적인 쫓아내기 로직!
            // 조건 1: 아직 숫자를 지울 수 있는 기회(k)가 남아있고
            // 조건 2: 상자가 비어있지 않으며
            // 조건 3: 상자의 맨 끝(방금 들어간) 숫자가 지금 넣을 숫자(c)보다 작다면?
            while (k > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < c) {
                // 상자 맨 끝에 있는 작은 숫자를 가차 없이 지워버립니다!
                answer.deleteCharAt(answer.length() - 1);
                k--; // 지울 기회를 1번 사용했습니다.
            }

            // 쫓아낼 애들을 다 쫓아냈으니, 이제 내 숫자를 상자에 넣습니다.
            answer.append(c);
        }

        // 🚨 4. 엣지 케이스 (가장 많이 틀리는 함정)
        // 만약 숫자가 "98765" 처럼 이미 완벽한 내림차순이라서 한 번도 지우지 않았다면?
        // 기회(k)가 고스란히 남아있으므로, 맨 뒤에서부터 남은 k개만큼 쿨하게 잘라냅니다.
        if (k > 0) {
            answer.delete(answer.length() - k, answer.length());
        }

        // 완성된 숫자를 문자열로 변환하여 반환!
        return answer.toString();
    }
}