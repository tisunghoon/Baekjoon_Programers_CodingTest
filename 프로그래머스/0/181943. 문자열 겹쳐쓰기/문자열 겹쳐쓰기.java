class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        // 1. 앞부분 자르기: 처음(0)부터 덮어쓰기가 시작되는 위치(s) 직전까지 자릅니다.
        String front = my_string.substring(0, s);
        
        // 2. 뒷부분 시작 위치 찾기: (시작 위치 s) + (덮어쓸 문자열의 길이)
        int endIdx = s + overwrite_string.length();
        
        // 3. 뒷부분 자르기: 덮어쓰기가 끝난 지점부터 문자열의 마지막까지 몽땅 가져옵니다.
        String back = my_string.substring(endIdx);
        
        // 4. 조립하기: 앞부분 + 덮어쓸 문자열 + 뒷부분
        return front + overwrite_string + back;
    }
}