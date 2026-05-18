class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int temp = 0;
    
        // 1. 오타 수정: querice -> queries
        for(int[] query : queries){
            temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        } // for문 끝
        
        // 2. 중괄호 위치 조정: return문이 solution 메서드 내부에 안전하게 위치해야 합니다.
        int[] answer = arr;
        return answer;
    } // solution 메서드 끝
} // class 끝