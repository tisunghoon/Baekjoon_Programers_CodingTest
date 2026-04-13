import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // 가격이 떨어지지 않은 주식들의 '인덱스(시간)'를 담을 스택
        Stack<Integer> stack = new Stack<>();

        // 1. 시간의 흐름(초)에 따라 주식 가격을 하나씩 확인합니다.
        for (int i = 0; i < n; i++) {
            
            // 2. 과거의 주식 가격이 현재 가격보다 크다면? -> "가격이 떨어졌다!"
            // 스택이 비어있지 않고, 스택 맨 위의 시간(과거)에 해당하는 주식 가격이 현재 가격보다 큰 동안 반복
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                
                // 가격이 떨어진 과거의 시간을 스택에서 빼냅니다.
                int pastTime = stack.pop();
                
                // 가격이 유지된 시간 = 현재 시간(i) - 과거 시간(pastTime)
                answer[pastTime] = i - pastTime;
            }
            
            // 3. 현재 시간(인덱스)을 스택에 넣어서 "아직 가격이 안 떨어졌음" 상태로 만듭니다.
            stack.push(i);
        }

        // 4. 시간이 끝날 때까지 가격이 한 번도 떨어지지 않은 주식들 처리
        // 스택에 남아있는 인덱스들은 배열의 끝(n - 1)까지 가격이 떨어지지 않은 것입니다.
        while (!stack.isEmpty()) {
            int pastTime = stack.pop();
            // 유지된 시간 = 마지막 시간(n - 1) - 과거 시간(pastTime)
            answer[pastTime] = (n - 1) - pastTime;
        }

        return answer;
    }
}