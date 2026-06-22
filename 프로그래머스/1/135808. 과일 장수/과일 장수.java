import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int maxProfit = 0;
        
        // 1. 사과 점수를 오름차순으로 정렬
        Arrays.sort(score);
        
        // 2. 가장 비싼 사과(배열의 맨 뒤)부터 m개씩 묶어 상자를 구성
        // 상자의 최저 점수는 항상 상자에 담긴 m개의 사과 중 가장 첫 번째(왼쪽) 값
        for (int i = score.length - m; i >= 0; i -= m) {
            // 해당 상자의 최저 점수(score[i]) * 사과 개수(m)를 총이익에 누적
            maxProfit += score[i] * m;
        }
        
        return maxProfit;
    }
}