import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        // 1. 오늘 날짜를 일(day) 단위 정수로 변환
        int todayDays = dateToDays(today);
        
        // 2. 약관 종류를 HashMap에 저장 (달 -> 일로 변환)
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            // split[0] = 약관 종류(A, B, C...)
            // split[1] = 유효기간(달). 28을 곱해 일 수로 저장
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        // 3. 개인정보 유효기간 검사
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int privacyDays = dateToDays(split[0]);
            String termType = split[1];
            
            // 만료일 = 수집일 + 약관 유효기간
            int expireDays = privacyDays + termMap.get(termType);
            
            // 오늘 날짜가 만료일과 같거나 지났다면 파기 대상 (1-based index)
            if (todayDays >= expireDays) {
                answerList.add(i + 1);
            }
        }
        
        // 4. List를 배열로 변환하여 반환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 날짜 문자열("YYYY.MM.DD")을 일(day) 단위 총합 정수로 변환하는 헬퍼 메서드
    private int dateToDays(String dateStr) {
        // 정규표현식에서 마침표(.)는 임의의 문자를 의미하므로 \\. 으로 이스케이프 처리
        String[] split = dateStr.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}