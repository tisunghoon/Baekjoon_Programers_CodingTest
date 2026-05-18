class Solution {
    public String solution(int[] numLog) {
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=1; i<numLog.length; i++){
            int diff = numLog[i]-numLog[i-1];
            switch (diff) {
                case 1 : 
                    answer.append("w");
                    break;
                case -1 :
                    answer.append("s");
                    break;
                case 10 :
                    answer.append("d");
                    break;
                case -10 :
                    answer.append("a");
                    break;
            }
        }
            
        return answer.toString();
    }
}

/* 내가 잘 몰라서 공부가 필요한 영역

1. stitch 구문 제대로 사용하는법
2. stringbuilder 사용법
3. 배열길이를 나타내는 length 사용법 

*/