class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            // i가 어떤 수의 제곱수인지 판별
            if (i % Math.sqrt(i) == 0) {
                // 제곱수라면 약수의 개수가 홀수이므로 뺀다
                answer -= i;
            } else {
                // 그 외의 수는 약수의 개수가 짝수이므로 더한다
                answer += i;
            }
        }
        
        return answer;
    }
}