class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            // 두 변 중 긴 부분을 width, 짧은 부분을 height로 설정
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            
            // 가장 긴 width와 가장 긴 height를 갱신
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        // 최종적으로 구한 가로 길이와 세로 길이를 곱하여 넓이 반환
        return maxWidth * maxHeight;
    }
}