class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        // 알파벳 대문자 A-Z는 총 26개이므로, 크기가 26인 배열 선언
        int[] keyDict = new int[26];
        
        // 최소값을 구하기 위해 배열의 모든 요소를 매우 큰 값으로 초기화
        for(int i = 0; i<26; i++){
            keyDict[i] = Integer.MAX_VALUE;
        }
        
        // 1. keymap을 순회하며 각 문자의 '최소 누름 횟수'를 배열에 기록
        for (String key : keymap)  {
            for(int i =0; i < key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i +1; // 누름 횟수
                int index = c - 'A';  // 아스키 코드로 계산, 'A'는 0, 'B'는 1, ...
                
                // 기존 배열에 저장된 값보다 현재 누름 횟수가 더 작으면 갱신
                if (pressCount < keyDict[index]) {
                    keyDict[index] = pressCount;
                } 
            }
        }
        
        // 2. targets를 순회하며 목표 문자열 작성 총 횟수 계산
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                int index = c - 'A';
                
                // 해당 문자의 인덱스 값이 여전히 초기값이라면 자판에 없는 문자임
                if (keyDict[index] == Integer.MAX_VALUE) {
                    totalPress = -1;
                    break;
                }
                
                
                // 자판에 있다면 최소 누름 횟수를 더함
                totalPress += keyDict[index];
                
            }
            
            answer[i] = totalPress;
        }
        
        
        return answer;
    }
}

