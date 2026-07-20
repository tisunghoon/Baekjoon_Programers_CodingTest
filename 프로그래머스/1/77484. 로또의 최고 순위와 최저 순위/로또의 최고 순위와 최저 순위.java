class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
        
        // 1. 0의 개수와 일치하는 번호의 개수를 구합니다.
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else {
                for (int win_num : win_nums) {
                    if (lotto == win_num) {
                        matchCount++;
                        break;
                    }
                }
            }
        }
        
        // 2. 맞힌 개수에 따른 순위 배열을 미리 정의합니다.
        // 인덱스(맞힌 개수) : 0, 1, 2, 3, 4, 5, 6
        // 배열 값(순위)    : 6, 6, 5, 4, 3, 2, 1
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        // 최고 순위: 맞힌 개수 + 0의 개수
        int maxRank = rank[matchCount + zeroCount];
        
        // 최저 순위: 현재 맞힌 개수 (0이 모두 틀렸다고 가정)
        int minRank = rank[matchCount];
        
        return new int[]{maxRank, minRank};
    }
}