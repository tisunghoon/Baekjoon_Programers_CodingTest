import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 1. commands의 개수만큼 결과가 나오므로 그 크기대로 answer 배열 생성
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            // commands[i][0] : 시작 인덱스 (1-based)
            // commands[i][1] : 끝 인덱스 (1-based)
            // commands[i][2] : 몇 번째 숫자인지 (k)
            
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            // 2. 배열 자르기
            // Arrays.copyOfRange(배열, 시작인덱스, 끝인덱스)
            // 주의: 시작인덱스는 포함, 끝인덱스는 미포함이므로 
            // 문제의 1-based 인덱스를 0-based로 맞추기 위해 start-1을 해줌
            int[] temp = Arrays.copyOfRange(array, start - 1, end);

            // 3. 정렬하기
            Arrays.sort(temp);

            // 4. k번째 숫자 찾기 (k번째는 인덱스로 k-1)
            answer[i] = temp[k - 1];
        }

        return answer;
    }
}