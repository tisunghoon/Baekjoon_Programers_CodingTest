import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int step = 0;
            
            // 지정된 index만큼 유효한 문자를 이동할 때까지 반복
            while (step < index) {
                c++; 
                
                // 'z'를 넘어가면 'a'로 순환
                if (c > 'z') {
                    c = 'a';
                }
                
                // 현재 문자가 skip에 포함되지 않는다면 이동 횟수 1 증가
                if (!skip.contains(String.valueOf(c))) {
                    step++;
                }
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}