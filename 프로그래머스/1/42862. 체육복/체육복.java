class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. 학생들의 체육복 상태 장부 만들기
        // 인덱스를 1번부터 n번까지 편하게 쓰고, 
        // 맨 앞(0번)과 맨 뒤(n+1번)에 가짜 학생을 두어 '배열 범위 초과 에러'를 방지합니다!
        int[] students = new int[n + 2]; 

        // 2. 도난당한 학생 기록 (-1)
        for (int l : lost) {
            students[l]--;
        }

        // 3. 여벌을 가져온 학생 기록 (+1)
        // 만약 도난당했는데 여벌이 있다면 -1 + 1 = 0 이 되어 자동으로 정상 처리됩니다!
        for (int r : reserve) {
            students[r]++;
        }

        // 4. 체육 수업을 들을 수 있는 최대 학생 수 계산
        int answer = n; // 처음엔 일단 모두가 들을 수 있다고 가정합니다.

        // 5. 1번 학생부터 탐욕법(Greedy) 적용
        for (int i = 1; i <= n; i++) {
            
            // 내가 체육복이 없다면(-1)
            if (students[i] == -1) {
                
                // 탐욕적 선택 1순위: 앞번호(i-1) 학생에게 빌린다!
                if (students[i - 1] == 1) {
                    students[i]++;      // 내 상태 정상화 (0)
                    students[i - 1]--;  // 앞번호 학생 여벌 소진 (0)
                } 
                // 탐욕적 선택 2순위: 뒷번호(i+1) 학생에게 빌린다!
                else if (students[i + 1] == 1) {
                    students[i]++;      // 내 상태 정상화 (0)
                    students[i + 1]--;  // 뒷번호 학생 여벌 소진 (0)
                } 
                // 양쪽 다 여벌이 없다면...
                else {
                    answer--; // 체육 수업을 들을 수 없는 학생 발생 ㅠㅠ
                }
            }
        }

        return answer;
    }
}