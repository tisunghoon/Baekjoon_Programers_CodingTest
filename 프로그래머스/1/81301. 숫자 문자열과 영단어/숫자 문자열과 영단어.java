class Solution {
    public int solution(String s) {
        // 인덱스와 숫자가 일치하도록 영단어 배열을 선언합니다.
        // words[0] = "zero", words[1] = "one" ...
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 0부터 9까지 반복하며 문자열에 포함된 영단어를 숫자로 치환합니다.
        for (int i = 0; i < words.length; i++) {
            // String.replace(기존 문자열, 바꿀 문자열) 사용
            s = s.replace(words[i], String.valueOf(i));
        }
        
        // 변환이 완료된 문자열을 정수형(int)으로 변환하여 반환합니다.
        return Integer.parseInt(s);
    }
}