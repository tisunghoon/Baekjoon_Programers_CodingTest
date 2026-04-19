class Solution {
    public int solution(int number, int n, int m) {
        
        // (number가 n의 배수) 그리고 (number가 m의 배수) 둘 다 만족하면(?) 1 반환, 아니면(:) 0 반환!
        return (number % n == 0 && number % m == 0) ? 1 : 0;
        
    }
}