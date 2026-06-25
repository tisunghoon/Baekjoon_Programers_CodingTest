class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String word : babbling) {
            // 연속 발음 체크
            if (word.contains("ayaaya") || word.contains("yeye") || 
                word.contains("woowoo") || word.contains("mama")) {
                continue;
            }
            
            // 가능한 발음을 공백으로 치환
            word = word.replace("aya", " ");
            word = word.replace("ye", " ");
            word = word.replace("woo", " ");
            word = word.replace("ma", " ");
            
            // 치환 후 남은 모든 공백 제거
            word = word.replace(" ", "");
            
            // 남은 알파벳이 없다면 발음 가능한 단어
            if (word.length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}