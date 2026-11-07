import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
              return s1.charAt(n) - s2.charAt(n);
        });
    
        return strings;
    }
}

// Arrays.sort는 파라미터 값 받는 형식
// 기본형 배열과 객체 배열의 차이


/*
1. 기본 정렬: Arrays.sort(배열)

파라미터 (1개): 정렬할 배열 객체 하나만 넣습니다.

동작: 해당 데이터 타입이 가진 기본 정렬 기준(숫자는 작은 수부터, 문자열은 사전순)으로 알아서 오름차순 정렬합니다.

사용 예: Arrays.sort(strings);

2. 커스텀 정렬: Arrays.sort(배열, 정렬_규칙)
현재 풀고 계신 문제처럼 "n번째 글자 기준"이라는 나만의 특별한 규칙이 필요할 때 사용합니다. 파라미터를 두 개 받습니다.

첫 번째 파라미터 (strings): 정렬할 대상 배열입니다.

주의: 커스텀 정렬 규칙을 적용하려면 이 배열이 int[], double[] 같은 기본형 배열이 아니라 String[], Integer[] 같은 객체 배열이어야 합니다.

두 번째 파라미터 ((s1, s2) -> { ... }): 두 원소의 순서를 결정하는 정렬 규칙(Comparator)입니다. 람다식을 사용해 형태를 아주 간결하게 줄인 것입니다.

두 번째 파라미터(람다식)의 구성 요소 상세:

파라미터 선언부 (s1, s2): 정렬 알고리즘이 배열에서 꺼내온 두 원소를 담을 변수명입니다. a, b나 x, y처럼 이름은 마음대로 지어도 됩니다. 대상 배열이 String[]이므로 자바가 알아서 두 변수를 String 타입으로 인식합니다.

화살표 ->: 왼쪽의 변수들을 사용해서 오른쪽 중괄호 { } 안의 코드를 실행하라는 의미입니다.

실행부 { ... return 정수; }: s1과 s2를 비교하는 로직을 작성하고, 반드시 정수(int)를 반환(return)해야 합니다. 이 반환값(음수, 0, 양수)에 따라 컴퓨터가 두 원소의 순서를 최종적으로 결정합니다.
*/