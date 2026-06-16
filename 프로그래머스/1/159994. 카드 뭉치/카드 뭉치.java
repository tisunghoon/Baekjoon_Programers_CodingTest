class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; // cards1을 가리키는 포인터
        int idx2 = 0; // cards2를 가리키는 포인터
        
        // goal 배열의 단어를 하나씩 확인
        for (int i = 0; i < goal.length; i++) {
            String currentWord = goal[i];
            
            // 1. cards1에 아직 남아있는 카드가 있고, 현재 찾는 단어와 일치하는 경우
            if (idx1 < cards1.length && currentWord.equals(cards1[idx1])) {
                idx1++;
            } 
            // 2. cards2에 아직 남아있는 카드가 있고, 현재 찾는 단어와 일치하는 경우
            else if (idx2 < cards2.length && currentWord.equals(cards2[idx2])) {
                idx2++;
            } 
            // 3. 두 카드 뭉치 어디에서도 현재 필요한 단어를 꺼낼 수 없는 경우
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}