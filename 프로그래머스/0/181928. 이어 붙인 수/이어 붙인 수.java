class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String pair = "";
        
        for (int i : num_list){
            if(i%2==0){
                pair+=""+i;
            }
            else{
                odd+=""+i;
            }
        }
        answer = Integer.parseInt(pair)+Integer.parseInt(odd);
        
        return answer;      
    }
}
        /*
        1. 홀짝 판별하기
        2. String로 변환하기
        3. 이어 붙이기
        4. int 변환하고 더하기
        5. answer에 넣고 return 하기
        */    