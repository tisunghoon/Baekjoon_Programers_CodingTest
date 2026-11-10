class Solution {
    public String solution(String s) {
        String answer = "";
        
        int div = s.length()/2;
        
        if (s.length()%2==0) {
            return s.substring(div - 1, div + 1);
            } else {
                return s.substring(div, div + 1);
            }

    }
}



/*
문제 : 글자 개수가 홀수인지 짝수인지 판별하고 가운데 글자를 추출한다.

1. 판별해야 되고
2. 가운데 글자 추출해야됨

+ 람다함수로 축약할 수 있을까
+ stream으로 축약할 수 있을까
*/


