class Solution {
    public int solution(int n, int w, int num) {
        
        // 1. 꺼내려는 상자(num)의 층수(row)와 위치(col)를 계산합니다. (0부터 시작)
        int targetRow = (num - 1) / w;
        int targetCol;
        
        // 짝수 층은 정방향(왼->오), 홀수 층은 역방향(오->왼)입니다.
        if (targetRow % 2 == 0) {
            targetCol = (num - 1) % w;
        } else {
            targetCol = w - 1 - ((num - 1) % w);
        }
        
        int count = 0;
        int currentRow = targetRow; // 타겟 상자가 있는 층부터 꼭대기 방향으로 탐색 시작
        
        // 2. 수직으로 한 층씩 올라가며 상자가 존재하는지 확인합니다.
        while (true) {
            int boxNum;
            
            // 현재 탐색 중인 층(currentRow)의 방향에 따라 해당 자리의 상자 번호를 역으로 계산합니다.
            if (currentRow % 2 == 0) {
                boxNum = currentRow * w + targetCol + 1;
            } else {
                boxNum = currentRow * w + (w - 1 - targetCol) + 1;
            }
            
            // 3. 계산된 상자 번호가 창고에 있는 전체 상자(n) 이하라면 카운트를 올립니다.
            if (boxNum <= n) {
                count++;
                currentRow++; // 다음 층으로 이동!
            } else {
                // 상자 번호가 n을 초과했다면, 더 이상 그 위로는 상자가 없다는 뜻이므로 종료합니다.
                break;
            }
        }
        
        return count;
    }
}