class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // 스택으로 사용할 배열 (최대 크기는 들어오는 재료의 전체 길이)
        int[] stack = new int[ingredient.length];
        int sp = 0; // 스택 포인터 (현재 재료가 쌓일 위치)
        
        for (int i : ingredient) {
            // 1. 재료를 스택에 차곡차곡 쌓음
            stack[sp++] = i;
            
            // 2. 스택에 재료가 4개 이상 쌓였다면 햄버거 패턴(1-2-3-1) 확인
            if (sp >= 4) {
                // 방금 쌓인 최상단 4개의 재료가 [빵, 야채, 고기, 빵] 순서인지 검사
                if (stack[sp - 4] == 1 && 
                    stack[sp - 3] == 2 && 
                    stack[sp - 2] == 3 && 
                    stack[sp - 1] == 1) {
                    
                    // 햄버거가 완성되었으므로 정답 카운트 증가
                    answer++;
                    
                    // 3. 완성된 재료 4개를 스택에서 제거 (포인터를 4칸 뒤로 되돌림)
                    sp -= 4;
                }
            }
        }
        
        return answer;
    }
}