class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length; // 보드판의 길이
        int count = 0;        // 같은 색상으로 칠해진 이웃한 칸의 개수
        
        // 1. 상, 하, 좌, 우 이동을 위한 방향 벡터
        int[] dh = {-1, 1, 0, 0}; // h(행)의 변화량
        int[] dw = {0, 0, -1, 1}; // w(열)의 변화량
        
        // 2. 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            // 3. 이웃한 칸이 보드판 경계 내에 존재하는지 확인
            if (hCheck >= 0 && hCheck < n && wCheck >= 0 && wCheck < n) {
                // 4. 기준 칸과 이웃한 칸의 색상이 동일한지 비교 (문자열 비교)
                if (board[h][w].equals(board[hCheck][wCheck])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}