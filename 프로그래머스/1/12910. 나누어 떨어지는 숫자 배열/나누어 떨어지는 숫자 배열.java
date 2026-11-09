import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // 1. 나누어 떨어지는 값 필터링해서 리스트에 담기
        for(int num : arr) {
            if (num % divisor == 0){
                list.add(num);
            }
        }
        
        // 2. 나누어 떨어지는 값이 하나도 없는 경우
        if (list.isEmpty()) {
            return new int[] {-1};
        }
        
        // 3. 오름차순 정렬
        Collections.sort(list);
        
        // 4. ArrayList를 int[] 배열로 변환하여 
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}