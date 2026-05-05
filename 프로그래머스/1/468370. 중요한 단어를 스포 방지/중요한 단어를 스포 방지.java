import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        // 1. 스포일러 되지 않은(안전한) 단어들을 기억할 Set (빠른 검색용)
        Set<String> unspoiledSet = new HashSet<>();
        
        // 2. 스포일러 된 단어들을 발견한 순서대로 담아둘 List
        List<String> spoiledList = new ArrayList<>();
        
        int n = message.length();
        int i = 0;          // 문자열 탐색용 인덱스
        int rangeIdx = 0;   // 스포일러 구간 탐색용 인덱스
        
        // 3. 메시지를 처음부터 끝까지 문자 단위로 탐색하며 단어를 추출합니다.
        while (i < n) {
            // 공백을 만나면 건너뜁니다.
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            // 단어의 시작(start)과 끝(end) 인덱스를 정확히 찾아냅니다.
            int start = i;
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1; 
            String word = message.substring(start, end + 1);
            
            // 4. 투 포인터 최적화: 현재 단어보다 '완전히 앞서 있는' 스포일러 구간은 패스합니다.
            // (구간의 끝점이 단어의 시작점보다 작다면 지나간 구간입니다.)
            while (rangeIdx < spoiler_ranges.length && spoiler_ranges[rangeIdx][1] < start) {
                rangeIdx++;
            }
            
            boolean isSpoiled = false;
            int tempIdx = rangeIdx;
            
            // 5. 현재 단어와 스포일러 구간이 겹치는지 검사합니다.
            // (구간의 시작점이 단어의 끝점보다 작거나 같을 때까지만 확인하면 됩니다.)
            while (tempIdx < spoiler_ranges.length && spoiler_ranges[tempIdx][0] <= end) {
                // 구간의 끝점이 단어의 시작점보다 크거나 같다면 무조건 겹칩니다!
                if (spoiler_ranges[tempIdx][1] >= start) {
                    isSpoiled = true;
                    break;
                }
                tempIdx++;
            }
            
            // 6. 판별 결과에 따라 알맞은 바구니에 담습니다.
            if (isSpoiled) {
                spoiledList.add(word);
            } else {
                unspoiledSet.add(word);
            }
        }
        
        // 7. 스포일러 된 단어 중 '중요한 단어'만 필터링합니다.
        Set<String> importantSet = new HashSet<>();
        for (String word : spoiledList) {
            // 조건: 스포일러 되지 않은 채로 쓰인 적이 없어야 함 (!unspoiledSet.contains)
            if (!unspoiledSet.contains(word)) {
                importantSet.add(word); // Set에 넣으므로 자동으로 중복은 제거됩니다.
            }
        }
        
        // 최종적으로 모인 고유한 '중요한 단어'의 개수를 반환합니다.
        return importantSet.size();
    }
}