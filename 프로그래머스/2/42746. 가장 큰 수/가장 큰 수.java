import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        // 1. 숫자 배열을 문자열 배열로 변환합니다. (이어 붙이기 편하게!)
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 우리가 만든 특별한 규칙으로 정렬합니다. (내림차순)
        // o1과 o2를 이어 붙였을 때 더 큰 쪽이 앞으로 오도록 설정!
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 3. 예외 처리: 만약 가장 큰 수가 "0"으로 시작한다면, 나머지도 다 "0"이라는 뜻입니다.
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 4. 정렬된 문자열을 하나로 예쁘게 합칩니다.
        // (코딩 테스트에서는 문자열을 많이 합칠 때 StringBuilder를 쓰는 게 훨씬 빠릅니다!)
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        return answer.toString();
    }
}