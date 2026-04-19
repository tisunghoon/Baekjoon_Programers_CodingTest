class Solution {
    public int solution(int num, int n) {
        
        // num을 n으로 나눈 나머지가 0과 같다면? (즉, 배수라면)
        if (num % n == 0) {
            return 1; // 1을 반환
        } 
        // 나머지가 0이 아니라면? (배수가 아니라면)
        else {
            return 0; // 0을 반환
        }
        
    }
}