import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        // l부터 r까지 모든 숫자를 확인
        for (int i = l; i <= r; i++) {
            // 숫자를 문자열로 변환
            String str = String.valueOf(i);
            boolean isMagicNumber = true;
            
            // 각 자릿수가 '0' 또는 '5'인지 검사
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch != '0' && ch != '5') {
                    isMagicNumber = false;
                    break; // '0'이나 '5'가 아닌 숫자가 하나라도 있으면 탈출
                }
            }
            
            // '0'과 '5'로만 이루어진 숫자라면 리스트에 추가
            if (isMagicNumber) {
                list.add(i);
            }
        }
        
        // 리스트가 비어있으면 -1을 담은 배열 리턴
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        // ArrayList를 기본 타입 배열(int[])로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}