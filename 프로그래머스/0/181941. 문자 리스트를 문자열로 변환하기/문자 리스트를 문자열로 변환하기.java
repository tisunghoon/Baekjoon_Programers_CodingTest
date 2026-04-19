class Solution {
    public String solution(String[] arr) {
        
        StringBuilder answer = new StringBuilder();
        
        // 향상된 for문으로 배열 안의 문자열(s)을 하나씩 꺼냅니다.
        for (String s : arr) {
            answer.append(s); // 상자에 이어 붙이기
        }
        
        return answer.toString();
        
    }
}