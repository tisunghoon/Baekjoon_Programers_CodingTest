import java.util.Arrays;

class Solution {
    public String solution(String s) {
        // 1. 문자열을 문자 배열(char[])로 쪼갭니다.
        char[] chars = s.toCharArray();
        
        // 2. 문자 배열을 오름차순으로 정렬합니다. 
        // (예: "Zbcdefg" -> ['Z', 'b', 'c', 'd', 'e', 'f', 'g'])
        Arrays.sort(chars);
        
        // 3. StringBuilder를 이용해 문자열을 뒤집어줍니다(내림차순으로 변경).
        return new StringBuilder(new String(chars)).reverse().toString();
    }
}