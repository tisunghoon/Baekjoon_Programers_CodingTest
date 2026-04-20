class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String operator = ineq + eq;
        boolean isTrue = false;
        
        switch(operator){
            case">=":
                isTrue = (n>=m);
                break;
            case "<=":
                isTrue = (n<=m);
                break;
            case ">!":
                isTrue = (n>m);
                break;
            case "<!":
                isTrue = (n<m);
                break;
        }
        
        
        
        return isTrue ? 1 :0;
    }
}