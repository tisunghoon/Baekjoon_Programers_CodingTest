class Solution {
    public int solution(int n, String control) {
        // 문자열을 하나씩 쪼개서 문자로 확인
        for (char ch : control.toCharArray()) {
            switch(ch){
                case 'w' :
                    n +=1;
                    break;
                case 's' :
                    n -=1;
                    break;
                case 'd':
                    n +=10;
                    break;
                case 'a':
                    n -=10;
                    break;
            }
        }
        
        int answer = n;
        return answer;
    }
}