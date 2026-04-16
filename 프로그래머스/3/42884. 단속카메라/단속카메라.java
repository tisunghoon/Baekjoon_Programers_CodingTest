import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 1. 차량의 이동 경로를 "진출 지점(나가는 곳)" 기준으로 오름차순 정렬합니다.
        // o1[1]과 o2[1]은 각각 차량의 진출 지점을 의미합니다.
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int answer = 0; // 설치한 카메라의 개수
        
        // 2. 마지막으로 카메라를 설치한 위치
        // 처음에는 어떤 차도 찍히지 않도록, 제한사항의 최솟값(-30000)보다 더 작은 값으로 초기화합니다.
        int lastCamera = -30001; 

        // 3. 정렬된 차량 경로를 하나씩 확인합니다.
        for (int[] route : routes) {
            int entry = route[0]; // 현재 차량의 진입 지점
            int exit = route[1];  // 현재 차량의 진출 지점

            // 4. 핵심 방어선: 현재 차량의 '진입 지점'이 마지막 '카메라 위치'보다 뒤에 있다면?
            // -> 이 차는 기존 카메라에 찍히지 않았으므로, 새로운 카메라가 무조건 필요합니다!
            if (entry > lastCamera) {
                // 새로운 카메라를 이 차가 빠져나가는 '진출 지점'에 설치합니다. (탐욕적 선택)
                lastCamera = exit;
                // 카메라 대수를 1대 추가합니다.
                answer++;
            }
            // 만약 entry <= lastCamera 라면, 이 차는 이미 기존 카메라를 지나쳤다는 뜻이므로 무시하고 넘어갑니다.
        }

        return answer;
    }
}