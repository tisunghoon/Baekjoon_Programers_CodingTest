import java.util.HashMap;
import java.util.Map;


class Solution {
    public String solution(String[] survey, int[] choices) {
        // 각 유형 문자별 누적 점수
        Map<Character, Integer> score = new HashMap<>();
        for (char c : "RTCFJMAN".toCharArray()) score.put(c,0);
        
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 계열 유형
            char agree = survey[i].charAt(1); // 동의 게열 유형
            int choice = choices[i];
            
            if(choice < 4) {
                score.merge(disagree, 4 - choice, Integer::sum);
            } else if (choice > 4) {
                score.merge(agree, choice -4, Integer::sum);
            }
            // choice == 4 (모르겠음) 이면 점수 없음
        }
        
        // 지표별 쌍을 사전 순으로 정렬해 두면 동점 시 앞 글자 선택 = 사전 순 규칙 충족
        String []  indicators = {"RT", "CF", "JM", "AN"};
        StringBuilder result = new StringBuilder();
        
        for (String pair : indicators) {
            char first = pair.charAt(0); // 사전 순으로 빠른 유형
            char second = pair.charAt(1);
            // 동점 (>=)이면 사전 순으로 빠른 first 선택
            result.append(score.get(first) >= score.get(second) ? first : second);
        
            
        }
        
        return result.toString();
    }
}

