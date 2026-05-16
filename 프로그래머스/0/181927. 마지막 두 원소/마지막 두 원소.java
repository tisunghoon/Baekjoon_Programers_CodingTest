class Solution {
    public int[] solution(int[] num_list) {
        // 1. 기존 배열보다 크기가 1 큰 새 배열 생성
        int[] answer = new int[num_list.length + 1];
        
        // 2. 기존 배열의 값을 새 배열로 복사
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        
        // 3. 마지막 원소와 그 전 원소의 인덱스 정의
        int lastIdx = num_list.length - 1;
        int lastValue = num_list[lastIdx];
        int prevValue = num_list[lastIdx - 1];
        
        // 4. 조건에 따른 분기 처리 후 새 배열의 마지막 칸에 대입
        if (lastValue > prevValue) {
            answer[answer.length - 1] = lastValue - prevValue;
        } else {
            answer[answer.length - 1] = lastValue * 2;
        }
        
        return answer;
    }
}