class Solution {
    public int solution(String s) {
        int answer = 0;
        int cx = 0, cother = 0;   // cx: 기준 글자 x 개수, cother: x가 아닌 글자 개수
        char x = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cx == 0) {        // 새 조각 시작 — 첫 글자를 기준 x로
                x = c;
                cx = 1;
                cother = 0;
            } else {
                if (c == x) cx++;
                else cother++;
                if (cx == cother) { // 두 횟수가 같아지면 조각 분리
                    answer++;
                    cx = 0;
                    cother = 0;
                }
            }
        }
        if (cx > 0) answer++;     // 끝까지 안 맞은 마지막 조각도 한 개로 셈
        return answer;
    }
}