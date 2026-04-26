class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int a=1;
        int b=0;
        
        for(int i : num_list){
            b+=i;
            a*=i;
            
        }
        if (a<b*b){
            answer =1;
        }
        else {
            answer =0;
        }
        
        
        
        return answer;
    }
}