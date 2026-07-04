class Solution {
    public String solution(String X, String Y) {
        // 0부터 9까지 각 숫자의 등장 횟수를 저장할 배열
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // X의 각 숫자 카운트
        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        
        // Y의 각 숫자 카운트
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 가장 큰 수를 만들어야 하므로 9부터 0까지 역순으로 탐색
        for (int i = 9; i >= 0; i--) {
            // X와 Y에서 공통으로 나타나는 횟수(최솟값)만큼 추가
            int minCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < minCount; j++) {
                sb.append(i);
            }
        }
        
        // 1. 공통 숫자가 없는 경우
        if (sb.length() == 0) {
            return "-1";
        }
        
        // 2. 공통 숫자가 '0'으로만 구성된 경우 (예: "000" -> "0")
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        // 3. 정상적으로 완성된 가장 큰 수 반환
        return sb.toString();
    }
}