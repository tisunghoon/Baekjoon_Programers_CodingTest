class Solution {
    public String solution(String[] seoul) {
        int x = 0; // "Kim"의 위치(인덱스)를 저장할 정수형 변수
        
        // 1. 배열을 처음부터 끝까지 순회합니다.
        for (int i = 0; i < seoul.length; i++) {
            // 2. 현재 요소가 "Kim"과 같은지 비교합니다. (문자열 비교는 .equals() 사용)
            if (seoul[i].equals("Kim")) {
                x = i; // 위치를 찾았다면 x에 저장합니다.
                break; // "Kim"은 한 번만 나타나므로 찾은 즉시 반복문을 종료합니다.
            }
        }
        
        // 3. 찾은 인덱스 x를 활용해 결과 문자열을 만들어 반환합니다.
        String answer = "김서방은 " + x + "에 있다";
        return answer;
    }
}