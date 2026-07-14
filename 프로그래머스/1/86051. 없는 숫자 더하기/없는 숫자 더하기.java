class Solution {
    public int solution(int[] numbers) {
        // 0부터 9까지 모든 숫자의 합은 45입니다.
        int answer = 45;
        
        // 주어진 배열의 숫자들을 총합에서 차감합니다.
        for (int num : numbers) {
            answer -= num;
        }
        
        // 최종적으로 남은 값이 배열에 없는 숫자들의 합입니다.
        return answer;
    }
}